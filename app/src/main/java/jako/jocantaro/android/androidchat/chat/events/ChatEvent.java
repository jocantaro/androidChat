package jako.jocantaro.android.androidchat.chat.events;

import jako.jocantaro.android.androidchat.entities.ChatMessage;

/**
 * Created by jocantaro on 14/06/16.
 */
public class ChatEvent {

    ChatMessage msg;

    public ChatEvent(ChatMessage msg) {
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }
}
