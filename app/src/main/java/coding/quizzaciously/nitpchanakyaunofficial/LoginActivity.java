package coding.quizzaciously.nitpchanakyaunofficial;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.BindView;
import butterknife.ButterKnife;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.ChanakyaLogin;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.LoginError;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.Progressable;

import nitpchankyaunofficial.R;


public class LoginActivity extends AppCompatActivity {

//    private FirebaseAnalytics mFirebaseAnalytics;
    @BindView(R.id.userName)
    EditText userName;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;
    LoginTask loginTask;
    @BindView(R.id.forgot_password)
    TextView forgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
//        mFirebaseAnalytics.setUserProperty("geniosity","logged out");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginTask=new LoginTask();
                loginTask.execute(userName.getText().toString(),password.getText().toString());
            }

        });
        password.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    btnLogin.performClick();
                    return true;
                }
                return false;
            }
        });
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://exam.nitp.ac.in:9001/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    private class LoginTask extends AsyncTask<String,Integer,String> implements Progressable
    {
        int progress=0,errCode=-1;
        boolean success=false;
        ProgressDialog pd;
        String userName,password,cookie;
        @Override
        protected void onPreExecute() {
            View view = LoginActivity.this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            pd = new ProgressDialog(LoginActivity.this,R.style.AppTheme_Dark_Dialog);
            pd.setMessage(getString(R.string.logging));
            pd.setCancelable(false);
            pd.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            userName=strings[0];
            password=strings[1];
            ChanakyaLogin chanakyaLogin=new ChanakyaLogin(userName,password,this);
            cookie="";
            try {
                publishProgress(25);
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
        protected void onProgressUpdate(Integer... values) {
           //// TODO: 19-12-2016 Add progress updation
            pd.setProgress(values[0]);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            pd.dismiss();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();
            if(success)
            {
                log(10000);
                SharedPreferences.Editor editor=getSharedPreferences("User Details",MODE_PRIVATE).edit();
                editor.putString(getString(R.string.user_name),userName);
                editor.putString(getString(R.string.password),password);
                editor.apply();
                editor.commit();
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra(getString(R.string.cookie),cookie);
                startActivity(intent);
                finish();
            }
            else
            {
                String errorMsg="";
                log(errCode);
                switch(errCode)
                {
                    case LoginError.CONNECTION_ERROR:
                        errorMsg=getString(R.string.timeout);
                        break;
                    case LoginError.CREDENTIALS_ERROR:
                        errorMsg=getString(R.string.credential_error);
                        break;
                    case LoginError.SERVER_ERROR:
                        errorMsg=getString(R.string.server_error);
                }
                final AlertDialog alertDialog=new AlertDialog.Builder(LoginActivity.this,R.style.AppTheme_Dark_Dialog).setTitle(getString(R.string.error)).setMessage(errorMsg).create();
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.hide();
                    }
                });
                alertDialog.show();
            }
        }

        @Override
        public void progress() {
            onProgressUpdate(60);
        }
    }

    private void log(int success) {
        Bundle params = new Bundle();
        if(success==10000) {
            params.putString("Login", "success");
//            mFirebaseAnalytics.logEvent("login", params);
//            mFirebaseAnalytics.setUserProperty("geniosity","logged in");
        }
        else if (success==LoginError.CONNECTION_ERROR)
        {
            params.putString("Login", "timed out");
//            mFirebaseAnalytics.logEvent("login", params);
        }
        else if (success==LoginError.SERVER_ERROR)
        {
            params.putString("Login", "Danger error contact developer");
//            mFirebaseAnalytics.logEvent("login", params);
        }
        else
        {
            params.putString("Login", "Wrong Password");
//            mFirebaseAnalytics.logEvent("login", params);
        }

    }

    @Override
    public void onDestroy(){
        if(loginTask!=null)
            loginTask.cancel(false);
        super.onDestroy();
    }



}
