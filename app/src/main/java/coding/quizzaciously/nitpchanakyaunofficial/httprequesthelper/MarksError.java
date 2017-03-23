package coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper;

/**
 * Created by Raj on 20-12-2016.
 */

public class MarksError extends Exception {
    public int type;//The type of error among those options
    public static final int CONNECTION_ERROR=0;//If null response at any stage or timeoutex
    public static final int SERVER_ERROR=2;//If not incorrect username or password but incorrect cookie. Need an update
    public static final int CREDENTIALS_ERROR=3;//Wrong username and password
    public static int WRONG_SESSION_ERROR=4;
    public MarksError(int type)
    {
        this.type=type;
    }
    public int getType()
    {
        return this.type;
    }
}

