package jako.jocantaro.android.androidchat.addContact;

import jako.jocantaro.android.androidchat.addContact.events.AddContactEvent;

/**
 * Created by jocantaro on 13/06/16.
 */
public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addcontact (String email);
    void onEventMainThread (AddContactEvent event);
}
