package jako.jocantaro.android.androidchat.contactList.ui;

import jako.jocantaro.android.androidchat.entities.User;

public interface ContactListView {
    void onContactAdded (User user);
    void onContactChanged (User user);
    void onContactRemoved (User user);
}
