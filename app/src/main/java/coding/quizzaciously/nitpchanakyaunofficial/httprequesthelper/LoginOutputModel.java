package coding.quizzaciously.nitpchanakyaunofficial.httprequesthelper;

/**
 * Created by Raj on 19-12-2016.
 */
public class LoginOutputModel {
    private int result;
    private String cookie;
    public LoginOutputModel(int result, String cookie)
    {
        this.result=result;
        this.cookie=cookie;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
