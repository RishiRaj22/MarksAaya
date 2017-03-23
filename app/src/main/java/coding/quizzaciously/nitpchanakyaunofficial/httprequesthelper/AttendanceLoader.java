package coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Raj on 20-12-2016.
 */

public class AttendanceLoader {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/51.0";
    private static final String home="http://exam.nitp.ac.in:9001";
    private final Progressable progressable;
    private Context context;



    public String[] accessOptions(String cookie,String sessionValue) throws MarksError {//If sessionValue not to be given it is null
        URL obj;
        HttpURLConnection con = null;
        StringBuilder POST_MARKS = new StringBuilder(),temp=new StringBuilder();
        try {
            obj = new URL(home + "/attendancestatus.aspx");

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.d("Out", "url is no url");
            throw new MarksError(MarksError.SERVER_ERROR);
        }
        try {
            con = (HttpURLConnection) obj.openConnection();
            con.setReadTimeout(6000);
            progressable.progress();
            con.setConnectTimeout(6000);
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Cookie", cookie.toString());
            con.setRequestProperty("Referer", home + "/home.aspx");

            String inputLine = "";


            int responseCode = con.getResponseCode();
            progressable.progress();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((inputLine = in.readLine()) != null) {
                    Log.d("html",inputLine);
                    if (inputLine.contains("<option value=")) {
                        Log.d("temp4",temp.toString());
                        int l1=0;
                        for(l1=0;l1<inputLine.length();l1++) {

                            if (inputLine.charAt(l1) == '=') {
                                for (l1 += 2; inputLine.charAt(l1) != '"'; l1++) {
                                    temp.append(inputLine.charAt(l1));
                                }
                                temp.append('\n');
                                Log.d("temporary_real",temp.toString());
                                break;
                            }
                        }

                    }

                    if (inputLine.contains("<input type=\"hidden")) {

                        // //System.out.println(inputLine);
                        for (int l1 = 0; l1 < inputLine.length(); l1++) {
                            if ((inputLine.charAt(l1) == 'n') && (inputLine.charAt(l1 + 1) == 'a') && (inputLine.charAt(l1 + 2) == 'm') && (inputLine.charAt(l1 + 3) == 'e') && (inputLine.charAt(l1 + 4) == '=') && (inputLine.charAt(l1 + 5) == '"')) {
                                if (POST_MARKS.length()!=0) {
                                    POST_MARKS.append("&");
                                    // //System.out.println("Yes!!!!!!!!!!!!!!!!!!!!");
                                }
                                // //System.out.println(inputLine);
                                for (l1 = l1 + 6; inputLine.charAt(l1) != '"'; l1++) {
                                    POST_MARKS.append(inputLine.charAt(l1));
                                }
                                POST_MARKS.append("=");
                            }
                            if ((inputLine.charAt(l1) == 'v') && (inputLine.charAt(l1 + 1) == 'a') && (inputLine.charAt(l1 + 2) == 'l') && (inputLine.charAt(l1 + 3) == 'u') && (inputLine.charAt(l1 + 4) == 'e') && (inputLine.charAt(l1 + 5) == '=')) {
                                //// //System.out.println(inputLine);
                                for (l1 = l1 + 7; inputLine.charAt(l1) != '"'; l1++) {
                                    if ((inputLine.charAt(l1)) == '/')
                                        POST_MARKS.append("%2F");
                                    else if (inputLine.charAt(l1) == '=')
                                        POST_MARKS.append("%3D");
                                    else if (inputLine.charAt(l1) == '+')
                                        POST_MARKS.append("%2B");

                                    else
                                        POST_MARKS.append(inputLine.charAt(l1));
                                }
                            }
                        }
                    }//end of if hidden


                }
                progressable.progress();


                String[] options=temp.toString().split("[\\n]+");
                if(sessionValue==null)
                {
                    sessionValue=options[0];
                }
                Log.d("Out",temp.toString());
                POST_MARKS.append("&ctl00%24ContentPlaceHolder2%24btnsumit=Submit&ctl00%24ContentPlaceHolder2%24ddlexamsession="+sessionValue+"&ctl00%24ContentPlaceHolder2%24txtprogram=");
                in.close();
                con.disconnect();
                //POST
                byte[] postData= (POST_MARKS.toString()).getBytes();
                int postDataLength= postData.length;
                try {
                    con = (HttpURLConnection) obj.openConnection();

                    con.setRequestMethod("POST");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    con.setRequestProperty("Referer", "http://exam.nitp.ac.in:9001/default.aspx");
                    con.setRequestProperty("Cookie", cookie.toString());
                    con.setRequestProperty( "charset", "utf-8");
                    con.setInstanceFollowRedirects( false );
                    con.setRequestProperty("Content-Length", String.valueOf(postDataLength));
                    con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
                    con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                    con.setRequestProperty("Connection", "close");
                    con.setRequestProperty("Upgrade-Insecure-Requests", "1");






                    // For POST only - START
                    con.setDoOutput(true);
                    OutputStream os = con.getOutputStream();
                    // //System.out.println(os.toString());
                    con.getOutputStream().write(postData);
                    os.flush();
                    os.close();
                    progressable.progress();

                    String fc="";
                    boolean bola=false;
                    responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        StringBuffer returnValue=new StringBuffer();
                        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        PrintStream file =new PrintStream(context.openFileOutput("attendance_temp.html", Context.MODE_PRIVATE));
                        file.println(System.currentTimeMillis());
                        while ((inputLine = in.readLine()) != null)
                            file.print(inputLine);
                        progressable.progress();
                    }
                    else
                    {
                        throw new MarksError(MarksError.SERVER_ERROR);
                    }
                    return options;
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new MarksError(MarksError.CONNECTION_ERROR);
        }
        finally {
            con.disconnect();
        }
        return null;
    }
    public void setContext(Context context)
    {
        this.context=context;
    }
    public AttendanceLoader(Context context,Progressable progressable)
    {
        super();
        this.context=context;
        this.progressable=progressable;

    }

}
