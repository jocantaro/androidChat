package jako.jocantaro.android.androidchat.contactList;

/**
 * Created by Jocantaro on 12/06/2016.
 */
public interface ContactListSessionInteractor {

    //métodos para el manejo de la sesión
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus (boolean online);
}
