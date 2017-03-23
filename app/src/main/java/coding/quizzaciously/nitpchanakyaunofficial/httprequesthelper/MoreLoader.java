package coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper;

import android.content.Context;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Raj on 24-12-2016.
 */

public class MoreLoader {

    public MoreLoader(Context c)
    {
       this.context=c;
    }

    private static final String home="http://exam.nitp.ac.in:9001/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/51.0";
    private Context context;


    public ArrayList<String> Load(String cookie) throws LoginError {

        URL obj = null;
        ArrayList<String> name= new ArrayList<String>();
        try {
            obj = new URL(home+"home.aspx");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.d("Out","Impossible");
        }


        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) obj.openConnection();

            con.setConnectTimeout(6000);
            con.setReadTimeout(6000);

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Cookie", cookie.toString());
            con.setRequestProperty("Referer", home);
            con.setInstanceFollowRedirects(false);

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuffer returnValue=new StringBuffer();
                String inputLine="";
                StringBuilder stringBuilder=new StringBuilder();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((inputLine = in.readLine()) != null)
                    stringBuilder.append(inputLine);
                Document doc= Jsoup.parse(stringBuilder.toString());
                Elements tab=doc.select("a[href$=aspx]");

                for (Element e: tab)
                {
                    if((e.text().length()>1)&&(e.attr("href").length()>1)) {
                            name.add(e.text());
                            name.add(e.attr("href"));
                    }
                }
                name.add("Chanakya (Web Browser)");
                name.add("");
            }
        }
        catch (IOException ex)
        {
            throw new LoginError(LoginError.CONNECTION_ERROR);
        }
        finally {
            con.disconnect();
            return name;
        }

    }


}
