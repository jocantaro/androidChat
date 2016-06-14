package jako.jocantaro.android.androidchat.addContact;

import org.greenrobot.eventbus.Subscribe;

import jako.jocantaro.android.androidchat.addContact.AddContactPresenter;
import jako.jocantaro.android.androidchat.addContact.events.AddContactEvent;
import jako.jocantaro.android.androidchat.addContact.ui.AddContactView;
import jako.jocantaro.android.androidchat.lib.EventBus;
import jako.jocantaro.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by jocantaro on 14/06/16.
 */
public class AddContactPresenterImpl implements AddContactPresenter {

    private EventBus eventBus;
    private AddContactView view;
    private AddContactInteractor interactor;

    public AddContactPresenterImpl(AddContactView view) {
        this.view = view;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.interactor = new AddContactInteractorImpl();
    }

    @Override
    public void onShow() {
        eventBus.register(this);

    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);

    }

    @Override
    public void addcontact(String email) {
        if (view != null) {
            view.hideInput();
            view.showProgress();
        }
        interactor.execute(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(AddContactEvent event) {

        if (view != null){
            view.hideProgress();
            view.showInput();

            if (event.isError()){
                view.contactNotAdded();
            } else {
                view.contactAdded();
            }
        }

    }
}
