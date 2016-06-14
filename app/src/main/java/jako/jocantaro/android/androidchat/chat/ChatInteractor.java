package jako.jocantaro.android.androidchat.chat;

/**
 * Created by jocantaro on 14/06/16.
 */
public interface ChatInteractor {

    void sendMessage (String msg);
    void setRecipient (String recipient);
    void subscribe();
    void unsusbscribe();
    void destroyListener();

}
