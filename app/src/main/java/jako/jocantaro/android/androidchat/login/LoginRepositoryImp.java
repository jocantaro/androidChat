package jako.jocantaro.android.androidchat.login;

import android.util.Log;

import jako.jocantaro.android.androidchat.domain.FirebaseHelper;

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
        Log.e ("LoginRepositoryImp","signUP");

    }

    @Override
    public void signIn(String email, String password) {
        Log.e ("LoginRepositoryImp","signIn");
    }

    @Override
    public void checkSession() {
        Log.e ("LoginRepositoryImp","check session");
    }
}
