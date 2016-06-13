package jako.jocantaro.android.androidchat.contactList;

/**
 * Created by Jocantaro on 12/06/2016.
 */
public interface ContactListRepository {

    void signOff();
    String getCurrentUserEmail();
    void removeContact (String email);
    void destroyListener();
    void subscribeToContactListEvent();
    void unsubscribeToContactListEvent();
    void changeConnectionStatus(boolean online);
}
