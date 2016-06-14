package jako.jocantaro.android.androidchat.chat;

/**
 * Created by jocantaro on 14/06/16.
 */
public class ChatSessionInteractorImpl implements ChatSessionInteractor {
    ChatRepository repository;

    public ChatSessionInteractorImpl() {
        this.repository = new ChatRepositoryImpl();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.changeUserConnectionStatus(online);

    }
}
