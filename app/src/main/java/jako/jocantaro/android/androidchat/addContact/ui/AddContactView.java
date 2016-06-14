package jako.jocantaro.android.androidchat.addContact.ui;

/**
 * Created by jocantaro on 13/06/16.
 */
public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();
}
