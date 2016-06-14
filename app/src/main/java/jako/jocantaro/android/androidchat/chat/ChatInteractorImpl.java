package jako.jocantaro.android.androidchat.chat;

/**
 * Created by jocantaro on 14/06/16.
 */
public class ChatInteractorImpl implements ChatInteractor {
    ChatRepository chatRepository;

    public ChatInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void subscribe() {
        chatRepository.subscribeForChatUpates();
    }

    @Override
    public void unsusbscribe() {
        chatRepository.unSubscribeForChatUpates();
    }

    @Override
    public void destroyListener() {
        chatRepository.destroyChatListener();
    }

    @Override
    public void setRecipient(String recipient) {
        chatRepository.setReceiver(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatRepository.sendMessage(msg);
    }
}
