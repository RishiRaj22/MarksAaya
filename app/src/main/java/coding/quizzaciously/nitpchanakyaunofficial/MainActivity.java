package coding.quizzaciously.nitpchanakyaunofficial;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import nitpchankyaunofficial.R;

import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.ChanakyaLogin;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.LoginError;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.Progressable;

/**This is the main activity, which is visible only when you're logged in to your account.
 * This account checks whether the cookie associated with it is still valid by trying to access
 * some website inside Chanakya Portal. If there is an error, then it tries to login again
 *
 */
public class MainActivity extends AppCompatActivity {
    String cookie;
    private boolean networkQuery=true;
    HtmlTextView myTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences=getSharedPreferences("User Details",MODE_PRIVATE);
        setUpMainActivity();
        if(sharedPreferences.getString(getString(R.string.user_name),null)==null)
        {
            Intent intent=new Intent(this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }
        else {
            if (getIntent().getStringExtra(getString(R.string.cookie)) != null) {
                cookie = getIntent().getStringExtra(getString(R.string.cookie)).toString();
                TrySite trySite=new TrySite();
                trySite.execute(cookie);
            } else {
                GetCookie loginTask = new GetCookie();
                String userName = sharedPreferences.getString(getString(R.string.user_name), null);
                String password = sharedPreferences.getString(getString(R.string.password), null);
                loginTask.execute(userName, password);
            }
        }
    }
    private class GetCookie extends AsyncTask<String,Integer,String> implements Progressable
    {
        int errCode=-1;
        boolean success=false;
        ProgressDialog progressDialog;
        String userName,password,cookie;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setMessage(getString(R.string.logging));
            progressDialog.setMax(100);
            progressDialog.setProgress(0);
            progressDialog.show();
            progressDialog.setCancelable(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            userName=strings[0];
            password=strings[1];
            ChanakyaLogin chanakyaLogin=new ChanakyaLogin(userName,password,this);
            cookie="";
            try {
                cookie= chanakyaLogin.loginAndGetCookie();
                if(cookie.contains("appNameAuth"))
                    success=true;
            } catch (LoginError loginError) {
                errCode=loginError.getType();
            }
            finally {
            }
            return cookie;
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String errorMsg="";
            if(!success)
            {
                switch(errCode)
                {
                    case LoginError.CONNECTION_ERROR:
                        errorMsg=getString(R.string.timeout);
                        break;
                    case LoginError.CREDENTIALS_ERROR:
                        errorMsg=getString(R.string.pass_change);

                        break;
                    case LoginError.SERVER_ERROR:
                        errorMsg=getString(R.string.server_error);
                }
                final AlertDialog alertDialog=new AlertDialog.Builder(MainActivity.this).setTitle(getString(R.string.error)).setMessage(errorMsg).create();
                if(errCode==LoginError.CREDENTIALS_ERROR)
                {
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.logout), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            logout();
                        }
                    });
                    alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.retry), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            alertDialog.hide();
                            new GetCookie().execute(userName,password);
                        }
                    });
                    alertDialog.show();
                    progressDialog.hide();
                    return;
                }
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.cont_off), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.hide();
                        networkQuery=false;
                        return;

                    }
                });
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.retry), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.hide();
                        new GetCookie().execute(userName,password);
                    }
                    });
                alertDialog.show();
                progressDialog.hide();
                return;
            }
            else
            {
                TrySite trySite=new TrySite(progressDialog);
                trySite.execute(cookie);
            }
            MainActivity.this.cookie=s;

        }

        @Override
        public void progress() {
            publishProgress(33);

        }
    }

//    private void launchDefaultScreen() {
//        SharedPreferences sharedPreferences=getSharedPreferences(getString(R.string.default_launcher),MODE_PRIVATE);
//        String def;
//        if(getIntent().getAction()!=null&&getIntent().getCategories()!=null&&( def=sharedPreferences.getString(getString(R.string.default_launcher),null))!=null)
//        {
////            Intent intent=new Intent(this,xyzActivity.class);
////            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////            startActivity(intent);
////            finish();
//
//        }
//    }
    private class TrySite extends AsyncTask<String,Void,Boolean>
{
    ProgressDialog pd;
    public TrySite()
    {
        pd=new ProgressDialog(MainActivity.this);
        pd.setMax(100);
        pd.setMessage(getString(R.string.reconn));
        pd.setCancelable(false);
    }
    public TrySite(ProgressDialog progressDialog)
    {
        pd=progressDialog;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        ChanakyaLogin chanakyaLogin=new ChanakyaLogin(MainActivity.this);
        try {
            return chanakyaLogin.YetConnected(params[0]);
        } catch (LoginError loginError) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(aBoolean!=null) {
            if(!aBoolean) {
                SharedPreferences sharedPreferences=getSharedPreferences("User Details",MODE_PRIVATE);
                GetCookie loginTask = new GetCookie();
                String userName = sharedPreferences.getString(getString(R.string.user_name), null);
                String password = sharedPreferences.getString(getString(R.string.password), null);
                loginTask.execute(userName, password);
            }
            else
                getSpeech();

        }
        pd.hide();


    }

}

    private void getSpeech() {
        File file = new File(MainActivity.this.getFilesDir(), "speech_temp.html");
        FileReader reader= null;
        try {
            reader = new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String str="";
        StringBuilder text=new StringBuilder();
        while((str=bufferedReader.readLine())!=null)
            text.append(str);
            myTextView.setHtml(text.toString());
} catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpMainActivity(){
        this.setContentView(R.layout.activity_main);
        Button marks,attendance,logout,more;
        myTextView=(HtmlTextView) findViewById(R.id.html_text);
        marks= (Button) findViewById(R.id.marks_button);
        attendance= (Button) findViewById(R.id.attendance_button);
        logout=(Button) findViewById(R.id.logout_button);
        more=(Button) findViewById(R.id.more_button);
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marksIntent(v);
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendanceIntent(v);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent=new Intent(MainActivity.this,InfoActivity.class);
                                          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                          intent.putExtra("cookie", cookie);
                                          intent.putExtra("isOnline",networkQuery);
                                          startActivity(intent);
                                          finish();
                                      }
                                  });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MoreActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("cookie", cookie);
                intent.putExtra("isOnline",networkQuery);
                startActivity(intent);
                finish();
            }
        });
        getSpeech();
    }

    private void logout() {
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(MainActivity.this).setTitle("Logout").setMessage("Are you sure you want to logout?").create();
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                File file = new File(MainActivity.this.getFilesDir(), "marks_temp.html");
                file.delete();
                file = new File(MainActivity.this.getFilesDir(), "attendance_temp.html");
                file.delete();
                file = new File(MainActivity.this.getFilesDir(), "more_temp.html");
                file.delete();
                SharedPreferences.Editor sharedEdit = getSharedPreferences("User Details", MODE_PRIVATE).edit();
                sharedEdit.clear();
                sharedEdit.commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                alertDialog.hide();

            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.hide();
            }
        });
        alertDialog.show();
    }

    public void attendanceIntent(View view){
        Intent intent=new Intent(this,AttendanceActivity.class);
        intent.putExtra(getString(R.string.cookie),cookie);
        intent.putExtra("isOnline",networkQuery);
        startActivity(intent);
        finish();
    }
    public void marksIntent(View view){
        Intent intent=new Intent(this,MarksActivity.class);
        intent.putExtra(getString(R.string.cookie),cookie);
        intent.putExtra("isOnline",networkQuery);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        logout();
        return true;
    }
}
