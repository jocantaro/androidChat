package jako.jocantaro.android.androidchat.contactList;

/**
 * Created by jocantaro on 13/06/16.
 */
public class ContactListInteractorImpl implements ContactListInteractor {

    ContactListRepository repository;

    public ContactListInteractorImpl (){
        repository = new ContactListRepositoryImp();
    }

    @Override
    public void subscribe() {
        repository.subscribeForContactListUpdates();
    }

    @Override
    public void unsubscribe() {
        repository.unSubscribeForContactListUpdates();
    }

    @Override
    public void destroyListener() {
        repository.destroyContactListListener();

    }

    @Override
    public void removeContact(String email) {
        repository.removeContact(email);

    }
}
