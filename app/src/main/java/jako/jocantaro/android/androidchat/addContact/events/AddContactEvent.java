package jako.jocantaro.android.androidchat.addContact.events;

/**
 * Created by jocantaro on 13/06/16.
 */
public class AddContactEvent {

    boolean error = false;

    public boolean isError(){
        return error;
    }

    public void setError (boolean error) {
        this.error = error;
    }

}
