package jako.jocantaro.android.androidchat.login;

/**
 * Created by jocantaro on 9/06/16.
 */
public interface LoginRepository {

    void signUp (String email, String password);
    void signIn (String email, String password);
    void checkSession();


}
