package coding.quizzaciously.nitpchanakyaunofficial;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.LoginError;
import coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper.MoreLoader;

import nitpchankyaunofficial.R;


public class MoreActivity extends AppCompatActivity {
    String cookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        cookie = getIntent().getStringExtra(getString(R.string.cookie));
        TrySite t= new TrySite();
        t.execute(cookie);


    }

    @Override
    public void onBackPressed() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        if (getIntent().getBooleanExtra("isOnline", true))
            mainActivityIntent.putExtra(getString(R.string.cookie), cookie);
        startActivity(mainActivityIntent);
        finish();
    }

    private class TrySite extends AsyncTask<String,Void, ArrayList<String>>
    {
        ProgressDialog pd;
        public TrySite()
        {
            pd=new ProgressDialog(MoreActivity.this);
            pd.setMessage("Loading More");
            pd.setCancelable(false);
        }
        @Override
        public void onPreExecute()
        {
            super.onPreExecute();
            pd.show();
        }
        @Override
        protected ArrayList<String> doInBackground(String... cookie) {
            MoreLoader m = new MoreLoader(MoreActivity.this);
            ArrayList<String> s= new ArrayList<String>();
            try {
                s =m.Load(cookie[0]);
            } catch (LoginError loginError) {
                loginError.printStackTrace();
            }
            return s;
        }
        @Override
        protected void onPostExecute (ArrayList<String> s)
        {
            getList(s);
            pd.hide();

        }

    }
    public void getList(ArrayList<String> s)
    {
        final ArrayList<String>name= new ArrayList<String>();
        final ArrayList<String>link= new ArrayList<String>();
        int total=0;
        for(int i=0;i<s.size();total++,i+=2)
        name.add(s.get(i));
        final int tot=total;

        for(int i=1;i<s.size();i+=2)
            link.add(s.get(i));


        final ArrayAdapter adapter= new ArrayAdapter(this, R.layout.more_text, name);
        ListView listView=(ListView)(findViewById(R.id.listView));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position!=(tot-1)) {

                    if(!link.get(position).contains("AdmitCardPrin.aspx")) {

                        Intent web = new Intent(MoreActivity.this, WebViewActivity.class);
                        web.putExtra("cookie", cookie);
                        web.putExtra("site", "http://exam.nitp.ac.in:9001/" + link.get(position));
                        web.putExtra("name", name.get(position));
                        startActivity(web);
                        finish();
                    }
                    else
                    {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MoreActivity.this);
                        builder1.setMessage("Downloading Admit card is not supported in app");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Open Browser",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse("http://exam.nitp.ac.in:9001/"));
                                        startActivity(i);
                                        dialog.cancel();
                                    }
                                });

                        builder1.setNegativeButton(
                                "Back",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                }
                else
                {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("http://exam.nitp.ac.in:9001/"));
                    startActivity(i);
                }

            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
