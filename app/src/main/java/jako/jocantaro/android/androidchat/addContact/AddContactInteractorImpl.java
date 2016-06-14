package jako.jocantaro.android.androidchat.addContact;

/**
 * Created by jocantaro on 14/06/16.
 */
public class AddContactInteractorImpl implements AddContactInteractor {
    AddContactRepository repository;

    public AddContactInteractorImpl(){
        repository = new AddContactRepositoryImpl();
    }

    @Override
    public void execute(String email) {
        repository.addContact(email);

    }
}
