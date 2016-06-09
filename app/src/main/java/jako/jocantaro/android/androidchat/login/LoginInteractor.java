package jako.jocantaro.android.androidchat.login;

/**
 * Created by jocantaro on 9/06/16.
 */
public interface LoginInteractor {

    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email,String password);

}
