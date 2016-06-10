package jako.jocantaro.android.androidchat.login.events;

/**
 * Created by Jocantaro on 10/06/2016.
 */
public class LoginEvent {

    public final static int onSignInError = 0;
    public final static int onSignUpError=1;
    public final static int onSignInSuccess=2;
    public final static int onSignupSuccess=3;
    public final static int onFailedToRecoverSession = 4;

    private int eventType;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }




}
