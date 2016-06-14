package jako.jocantaro.android.androidchat;

import android.app.Application;

import com.firebase.client.Firebase;

import jako.jocantaro.android.androidchat.lib.GladeImageLoader;
import jako.jocantaro.android.androidchat.lib.ImageLoader;

public class AndroidChatApp extends Application
{

    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
        setupImageLoader();
    }

    private void setupImageLoader() {
        imageLoader = new GladeImageLoader(this);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private void setupFirebase() {
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
