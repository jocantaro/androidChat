package jako.jocantaro.android.androidchat.chat;

import jako.jocantaro.android.androidchat.chat.events.ChatEvent;

/**
 * Created by jocantaro on 14/06/16.
 */
public interface ChatPresenter {

    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient (String recipient);
    void sendMessage (String msg);
    void onEventMainThread (ChatEvent event);
}
