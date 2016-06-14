package jako.jocantaro.android.androidchat.chat.ui;

import jako.jocantaro.android.androidchat.entities.ChatMessage;

/**
 * Created by jocantaro on 14/06/16.
 */
public interface ChatView {
    void sendMessage();
    void onMessageReceived(ChatMessage msg);
    
}
