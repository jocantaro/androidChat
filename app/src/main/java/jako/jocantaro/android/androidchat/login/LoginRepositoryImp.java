package jako.jocantaro.android.androidchat.login;

import android.util.Log;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

import jako.jocantaro.android.androidchat.domain.FirebaseHelper;
import jako.jocantaro.android.androidchat.entities.User;
import jako.jocantaro.android.androidchat.lib.EventBus;
import jako.jocantaro.android.androidchat.lib.GreenRobotEventBus;
import jako.jocantaro.android.androidchat.login.events.LoginEvent;

/**
 * Created by Jocantaro on 10/06/2016.
 */
public class LoginRepositoryImp implements LoginRepository{

    private FirebaseHelper helper;
    private Firebase dataReference;
    private Firebase myUserReference;

    public LoginRepositoryImp (){
        this.helper = FirebaseHelper.getInstance();
        this.dataReference = helper.getDataReference();

        this.myUserReference = helper.getMyUserReference(); //esto va a ser nulo la primera vez, porque no hay correo asociado. Por eso hay que hacer otra asignación. L'inea 43

    }

    @Override
    public void signUp(final String email, final String password) {
        dataReference.createUser(email,password, new Firebase.ValueResultHandler<Map<String,Object>>(){

            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                postEvent(LoginEvent.onSignupSuccess);
                signIn(email,password);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignUpError,firebaseError.getMessage());

            }
        });
    }

    @Override
    public void signIn(String email, String password) {

        dataReference.authWithPassword(email,password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                initSignIn();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignInError,firebaseError.getMessage());

            }
        });
    }

    private void registerNewUser(){
        String email = helper.getAuthUserEmail();
        if (email!=null){
            User currentUser = new User();
            currentUser.setEmail(email);
            myUserReference.setValue(currentUser);
        }
    }

    @Override
    public void checkSession() {
        //comprobamos primero si est'a autentificado
        if(dataReference.getAuth() != null){
            initSignIn();
        } else {
            postEvent(LoginEvent.onFailedToRecoverSession);
        }
    }

    private void initSignIn(){
        myUserReference = helper.getMyUserReference();
        myUserReference.addListenerForSingleValueEvent( new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);

                //si cuando traemos los datos, el resultado es null, tenemos que agregarlo.
                if (currentUser == null){
                    registerNewUser();
                }
                helper.changedUserConnectionStatus(User.ONLINE);
                postEvent(LoginEvent.onSignInSuccess);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
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
