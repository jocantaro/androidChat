package jako.jocantaro.android.androidchat.login;

public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSignIn();

    void navigateToMainScree();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);

}
