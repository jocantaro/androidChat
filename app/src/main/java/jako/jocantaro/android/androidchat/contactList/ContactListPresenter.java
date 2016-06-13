package jako.jocantaro.android.androidchat.contactList;

import jako.jocantaro.android.androidchat.contactList.events.ContactListEvent;

/**
 * Created by Jocantaro on 12/06/2016.
 */
public interface ContactListPresenter {

    void onCreate();
    void onDestroy();
    //como trabajamos en Firebase en tiempo real, aplicamos los métodos onPause y onResume
    // para no tener siempre la conexión abierta
    void onPause();
    void onResume();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);


}
