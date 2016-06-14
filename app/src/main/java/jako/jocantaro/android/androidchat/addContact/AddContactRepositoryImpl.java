package jako.jocantaro.android.androidchat.addContact;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import jako.jocantaro.android.androidchat.addContact.events.AddContactEvent;
import jako.jocantaro.android.androidchat.domain.FirebaseHelper;
import jako.jocantaro.android.androidchat.entities.User;
import jako.jocantaro.android.androidchat.lib.EventBus;
import jako.jocantaro.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by jocantaro on 14/06/16.
 */
public class AddContactRepositoryImpl implements AddContactRepository {

    private EventBus eventBus;
    private FirebaseHelper helper;

    public AddContactRepositoryImpl() {
        this.eventBus = GreenRobotEventBus.getInstance();
        this.helper = FirebaseHelper.getInstance();
    }

    @Override

    public void addContact(final String email) {
        final String key = email.replace (".","_");
        Firebase userReference = helper.getUserReference(email);
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if ( user != null){
                    Firebase myContactReference = helper.getMyContactsReference();
                    myContactReference.child(key).setValue(user.isOnline());

                    String currentUserKey = helper.getAuthUserEmail();
                    currentUserKey = currentUserKey.replace(".","_");

                    Firebase reverseContactReference = helper.getContactsReference(email);
                    reverseContactReference.child(currentUserKey).setValue(User.ONLINE);

                    postSucces();

                } else {
                    postError();
                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                postError ();
            }
        });


    }

    private void postSucces() {
        post(false);
    }

    private void postError (){
        post(true);
    }
    private void post (boolean error) {
        AddContactEvent event = new AddContactEvent();
        event.setError(error);
        eventBus.post(event);
    }
}
