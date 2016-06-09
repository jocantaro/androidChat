package jako.jocantaro.android.androidchat;

import android.app.Application;

import com.firebase.client.Firebase;

public class AndroidChatApp extends Application
{

    @Override
    public void onCreate(){
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
