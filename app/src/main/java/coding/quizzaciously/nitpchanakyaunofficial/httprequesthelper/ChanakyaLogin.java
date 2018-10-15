package coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper;

import android.content.Context;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Raj on 19-12-2016. The basic login class
 */
public class ChanakyaLogin  {

    String userName,password;
    Context context;
    private Progressable progressable;
    private static final String home="http://exam.nitp.ac.in:9001/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/51.0";



    public ChanakyaLogin(String userName,String password,Progressable progressable)
    {
        this.userName=userName;
        this.password=password;
        this.progressable=progressable;
    }
    public ChanakyaLogin(Context context)
    {
        this.context=context;
    }


    public String loginAndGetCookie() throws LoginError {
        //TODO: ADD LOGIN AND GET COOKIE IMPLEMENTATION
        userName=getEncodedString(userName).toString();
        password=getEncodedString(password).toString();
        StringBuilder cookie=new StringBuilder();
        StringBuilder params=new StringBuilder();
        StringBuilder temp=new StringBuilder();


        System.out.println("enters");
        URL obj = null;
        try {
            obj = new URL(home);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection con= null;
        try {
            con = (HttpURLConnection) obj.openConnection();
            con.setReadTimeout(6000);
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                int headno=1;
                while(con.getHeaderFieldKey(headno)!=null)
                {
                    if (con.getHeaderFieldKey(headno).equals("Set-Cookie"))
                    {
                        cookie.append((con.getHeaderField(headno)+';'));
                    }
                    headno++;
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                boolean bool1=true;
                while ((inputLine = in.readLine()) != null) {

                    if (inputLine.contains("<input type=\"hidden")) {
                        for (int l1 = 0; l1 < inputLine.length(); l1++) {
                            bool1 = true;
                            if ((inputLine.charAt(l1) == 'n') && (inputLine.charAt(l1 + 1) == 'a') && (inputLine.charAt(l1 + 2) == 'm') && (inputLine.charAt(l1 + 3) == 'e') && (inputLine.charAt(l1 + 4) == '=') && (inputLine.charAt(l1 + 5) == '"')) {
                               if(params.length()>1)
                                params.append("&");
                                for ( l1=l1+6; inputLine.charAt(l1)!='"'; l1++)
                                {
                                    params.append(inputLine.charAt(l1));
                                }
                                params.append("=");

                            }
                            if ((inputLine.charAt(l1)=='v')&&(inputLine.charAt(l1+1)=='a')&&(inputLine.charAt(l1+2)=='l')&&(inputLine.charAt(l1+3)=='u')&&(inputLine.charAt(l1+4)=='e')&&(inputLine.charAt(l1+5)=='='))
                            {
                                bool1=false;
                                //// ////System.out.println(inputLine);
                                for (l1=l1+7; inputLine.charAt(l1)!='"'; l1++)
                                {
                                    if ((inputLine.charAt(l1))=='/')
                                        params.append("%2F");
                                    else if (inputLine.charAt(l1)=='=')
                                        params.append("%3D");
                                    else if (inputLine.charAt(l1)=='+')
                                        params.append("%2B");

                                    else
                                        params.append(inputLine.charAt(l1));
                                }
                            }


                        }
                    }

                    }
                in.close();

                }




            } catch (ProtocolException e1) {
            e1.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
            throw new LoginError(LoginError.CONNECTION_ERROR);
        }
        finally {
            con.disconnect();
            params.append("&txt_username="+userName+"&txt_password="+password+"&btnSubmitLogin=Login");
        }

        //get done
        if(progressable!=null)
            progressable.progress();
        try {
            byte[] postData= (params.toString()).getBytes();
            int postDataLength= postData.length;
            obj = new URL(home+"default.aspx");
            con = (HttpURLConnection) obj.openConnection();
            con.setReadTimeout(6000);
            con.setConnectTimeout(6000);
            con.setRequestMethod("POST");
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
            con.setRequestProperty("User-Agent", USER_AGENT);

            con.setDoOutput(true);

            OutputStream out = new BufferedOutputStream(con.getOutputStream());
            out.write(params.toString().getBytes());
            out.flush();
            out.close();
            int responseCode = con.getResponseCode();
            int headno=1;
            if (responseCode==302) {
                while (con.getHeaderFieldKey(headno) != null) {
                    if (con.getHeaderFieldKey(headno).equals("Set-Cookie")) {
                        // ////System.out.println((con.getHeaderField(headno)));
                        cookie.append((con.getHeaderField(headno) + ';'));
                    }
                    headno++;
                }
            }
            else if(responseCode==200)
                throw new LoginError(LoginError.CREDENTIALS_ERROR);
            else
                throw new LoginError(LoginError.CONNECTION_ERROR);







        } catch (ProtocolException e1) {
            e1.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new LoginError(LoginError.CONNECTION_ERROR);
        }
        finally {
            con.disconnect();
        }
        if(progressable!=null)
            progressable.progress();
        Log.d("Output login",cookie.toString());
        return cookie.toString();


    }
    private StringBuilder getEncodedString(String s1) {
        StringBuilder s2= new StringBuilder();
        try {
            s2.append(URLEncoder.encode(s1, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s2;
    }
    public boolean YetConnected(String cookie) throws LoginError {

        URL obj = null;
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
            if(responseCode==200) {
                String inputline=null;StringBuilder fileText=new StringBuilder();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while((inputline=in.readLine())!=null) {


                    if (inputline.contains("<div style=\"background-color:#fff;")) {
                        inputline = in.readLine();
                        while (!inputline.contains("</div>")) {
                            fileText.append(inputline);
                            inputline=in.readLine();
                        }
                        break;
                    }
                }
                in.close();
                PrintStream file =new PrintStream(context.openFileOutput("speech_temp.html", Context.MODE_PRIVATE));
                file.println(fileText.toString());
                return true;
            }
            else
                return false;
        }
        catch(IOException ex)
        {
            Log.d("Out", "Connection error in validating cookie");
            throw new LoginError(LoginError.CONNECTION_ERROR);
        }
        finally {
            con.disconnect();
        }
    }
}
