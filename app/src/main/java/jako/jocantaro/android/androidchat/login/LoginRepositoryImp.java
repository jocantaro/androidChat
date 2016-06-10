package jako.jocantaro.android.androidchat.login;

import android.util.Log;

import jako.jocantaro.android.androidchat.domain.FirebaseHelper;
import jako.jocantaro.android.androidchat.lib.EventBus;
import jako.jocantaro.android.androidchat.lib.GreenRobotEventBus;
import jako.jocantaro.android.androidchat.login.events.LoginEvent;

/**
 * Created by Jocantaro on 10/06/2016.
 */
public class LoginRepositoryImp implements LoginRepository{

    private FirebaseHelper helper;

    public LoginRepositoryImp (){
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signUp(String email, String password) {
        postEvent(LoginEvent.onSignupSuccess);
    }

    @Override
    public void signIn(String email, String password) {

        postEvent(LoginEvent.onSignInSuccess);
    }

    @Override
    public void checkSession() {
        postEvent(LoginEvent.onFailedToRecoverSession);

    }

    private void postEvent (int type, String errorMessage) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if (errorMessage != null) {
            loginEvent.setErrorMessage(errorMessage);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }

    private void postEvent (int type) {
        postEvent(type,null);
    }
}
