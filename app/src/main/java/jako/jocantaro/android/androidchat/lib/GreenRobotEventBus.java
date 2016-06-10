package jako.jocantaro.android.androidchat.lib;

/**
 * Created by Jocantaro on 10/06/2016.
 */
public class GreenRobotEventBus implements EventBus {

    de.greenrobot.event.EventBus eventBus;

    public GreenRobotEventBus(){
        this.eventBus = de.greenrobot.event.EventBus.getDefault();
    }

    private static class SingletonHolder {
        private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
    }

    public static GreenRobotEventBus getInstance(){
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);

    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);

    }
}
