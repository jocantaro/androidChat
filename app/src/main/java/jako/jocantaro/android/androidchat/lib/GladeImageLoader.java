package jako.jocantaro.android.androidchat.lib;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by jocantaro on 13/06/16.
 */
public class GladeImageLoader implements ImageLoader {
    private RequestManager requestManager;

    public GladeImageLoader (Context context) {

        this.requestManager = Glide.with(context);

    }
    @Override
    public void load(ImageView imgAvatar, String url) {

        requestManager.load (url).into(imgAvatar);

    }
}
