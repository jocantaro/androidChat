package jako.jocantaro.android.androidchat.contactList.ui;

import jako.jocantaro.android.androidchat.entities.User;


/**
 * Created by Jocantaro on 13/06/2016.
 */
public interface OnItemClickListener {

    void onItemClick(User user);
    void onItemLongClick(User user);


}