package jako.jocantaro.android.androidchat.contactList;

/**
 * Created by Jocantaro on 12/06/2016.
 */
public interface ContactListRepository {

    void signOff();
    String getCurrentEmail();
    void removeContact(String email);
    void destroyContactListListener();
    void subscribeForContactListUpdates();
    void unSubscribeForContactListUpdates();
    void changeUserConnectionStatus(boolean online);
}
