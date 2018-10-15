package coding.quizzaciously.nitpchanakyaunofficial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

import de.psdev.licensesdialog.LicensesDialog;
import nitpchankyaunofficial.R;


public class InfoActivity extends AppCompatActivity {

    String cookie;
    @BindView(R.id.share)
    AppCompatButton share;
    @BindView(R.id.rate)
    AppCompatButton rate;
    @BindView(R.id.feedback)
    AppCompatButton feedback;
    @BindView(R.id.apps)
    AppCompatButton apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cookie = getIntent().getStringExtra(getString(R.string.cookie));
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        rate.setOnClickListener(btnListener);
        feedback.setOnClickListener(btnListener);
        share.setOnClickListener(btnListener);
        apps.setOnClickListener(btnListener);

    }

    @Override
    public void onBackPressed() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        if (getIntent().getBooleanExtra("isOnline", true))
            mainActivityIntent.putExtra(getString(R.string.cookie), cookie);
        startActivity(mainActivityIntent);
        finish();
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {

        public void onClick(View v) {
            switch (v.getId()) {
                case (R.id.share):
                    String shareBody = "Download Marks Aaya app from "+"https://play.google.com/store/apps/details?id="+"coding.quizzaciously.nitpchanakyaunofficial"+" and check marks and attendance instantly. It works offline and shows the marks and attendance with detailed analysis.";
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Marks Aaya App");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, "Share App link using:"));      //do share hard
                    break;
                case (R.id.feedback):
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", "rishiraj.appdev@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback regarding Marks Aaya App");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Feedback:");
                    startActivity(Intent.createChooser(emailIntent, "Send email"));
                    break;
                case (R.id.rate):
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+"coding.quizzaciously.nitpchanakyaunofficial")));
                    break;
                case (R.id.apps):
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id="+"6779798392354094279")));
                    break;
                default:
                    //do no any hard
                    break;
            }
        }

    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        new LicensesDialog.Builder(this).setTitle("Open Source Licenses").setNotices(R.raw.notices).build().show();
        return true;
    }
}
