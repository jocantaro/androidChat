package jako.jocantaro.android.androidchat.lib;

/**
 * Created by Jocantaro on 10/06/2016.
 */
public interface EventBus {

    void register (Object subscriber);
    void unregister (Object subscriber);
    void post (Object event);

}
