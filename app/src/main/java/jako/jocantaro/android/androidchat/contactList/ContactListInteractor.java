package jako.jocantaro.android.androidchat.contactList;

/**
 * Created by Jocantaro on 12/06/2016.
 */
public interface ContactListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact (String email);
}
