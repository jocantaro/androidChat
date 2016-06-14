package jako.jocantaro.android.androidchat.contactList;

/**
 * Created by jocantaro on 13/06/16.
 */
public class ContactListSessionInteractorImpl implements ContactListSessionInteractor {

    ContactListRepositoryImp repository;

    public ContactListSessionInteractorImpl (){
        this.repository = new ContactListRepositoryImp();
    }

    @Override
    public void signOff() {
        repository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return repository.getCurrentEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.changeUserConnectionStatus(online);

    }
}
