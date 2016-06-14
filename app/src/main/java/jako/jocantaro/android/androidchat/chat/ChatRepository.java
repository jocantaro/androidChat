package jako.jocantaro.android.androidchat.chat;

/**
 * Created by jocantaro on 14/06/16.
 */
public interface ChatRepository {

    void sendMessage(String msg);
    void setReceiver(String receiver);

    void destroyChatListener();
    void subscribeForChatUpates();
    void unSubscribeForChatUpates();

    void changeUserConnectionStatus(boolean online);

}
