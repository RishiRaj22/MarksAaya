package coding.quizzaciously.nitpchanakyaunofficial;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import nitpchankyaunofficial.R;



public class WebViewActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private WebView webView;
    String cookie;
    String site="";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cookie = getIntent().getStringExtra(getString(R.string.cookie));
        site = getIntent().getStringExtra("site");
        name = getIntent().getStringExtra("name");
        setContentView(R.layout.activity_web_view);
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setBuiltInZoomControls(true);



        String[] cookies=cookie.split(";");
        for(String c:cookies)
        {
            CookieManager.getInstance().setCookie("http://exam.nitp.ac.in:9001/", c);
        }
        webView.setWebViewClient(new WebViewClient() {
                                     @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {

                                         // Check the URL here - if it is a file,
                                         // then initiate the download
                                         return false;
                                     }
                                 });
        webView.loadUrl(site);
        if (Build.VERSION.SDK_INT >= 23) {
            //do your check here
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            }
            else{
                ActivityCompat.requestPermissions(WebViewActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }

        }
        webView.setDownloadListener(new DownloadListener() {

            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                if (Build.VERSION.SDK_INT >= 23) {
                    //do your check here
                    if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        DownloadManager.Request request = new DownloadManager.Request(
                                Uri.parse(url));
                        request.addRequestHeader("Cookie", cookie);


                        String filenam = URLUtil.guessFileName(url, contentDisposition, mimetype);
                        final String filename = filenam.substring(0, (filenam.length() - 5)) + ".pdf";
                        request.allowScanningByMediaScanner();
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
                        DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                        dm.enqueue(request);
                        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT); //This is important!
                        intent.addCategory(Intent.CATEGORY_OPENABLE); //CATEGORY.OPENABLE
                        intent.setType("*/*");//any application,any extension
                        Toast.makeText(getApplicationContext(), "Downloading File", //To notify the Client that the file is being downloaded
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(WebViewActivity.this);
                        builder1.setMessage("Can't Download as permission not granted");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Grant Permission",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        ActivityCompat.requestPermissions(WebViewActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
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
                    DownloadManager.Request request = new DownloadManager.Request(
                            Uri.parse(url));
                    request.addRequestHeader("Cookie", cookie);


                    String filenam = URLUtil.guessFileName(url, contentDisposition, mimetype);
                    final String filename = filenam.substring(0, (filenam.length() - 5)) + ".pdf";
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
                    DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                    dm.enqueue(request);
                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT); //This is important!
                    intent.addCategory(Intent.CATEGORY_OPENABLE); //CATEGORY.OPENABLE
                    intent.setType("*/*");//any application,any extension
                    Toast.makeText(getApplicationContext(), "Downloading File", //To notify the Client that the file is being downloaded
                            Toast.LENGTH_LONG).show();
                }

            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        if (getIntent().getBooleanExtra("isOnline", true))
            mainActivityIntent.putExtra(getString(R.string.cookie), cookie);
        startActivity(mainActivityIntent);
        finish();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            //resume tasks needing this permission
        }
    }


}

