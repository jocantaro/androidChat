package jako.jocantaro.android.androidchat.login;

import jako.jocantaro.android.androidchat.login.events.LoginEvent;

/**
 * Created by Jocantaro on 10/06/2016.
 */
public class LoginPresenterImp implements LoginPresenter {
    LoginView loginView;
    LoginInteractor loginInteractor;

    public LoginPresenterImp (LoginView loginView){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImp();
    }

    public void onCreate(){

    }

    @Override
    public void onDestroy() {
        //evitamos un memory leak
        loginView = null;
    }

    @Override
    public void checkForAuthenticatedUser() {

        //si no es null significa que ya podemos estamos registrados.
        // Por tanto, deshabilitamos los inputs,
        // y comprobamos, llamando al interactor, si estamos o no logeados.
        if (loginView != null ) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        if (loginView != null ) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.doSignIn(email,password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if (loginView != null ) {
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.doSignUp(email,password);
    }

    @Override
    public void onEventMainThread(LoginEvent event) {

        switch (event.getEventType()){
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.onSignInError:
                onSignInError(event.getErrorMessage());
                break;
            case LoginEvent.onSignupSuccess:
                onSignUpSuccess();
                break;
            case LoginEvent.onSignUpError:
                onSignupError(event.getErrorMessage());
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedRecoverySession();
                break;
        }

    }

    private void onFailedRecoverySession (){


    }

    private void onSignInSuccess(){
        if (loginView != null ) {
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess(){
        if (loginView != null ) {
            loginView.newUserSuccess();
        }
    }

    private void onSignInError(String error){
        if (loginView != null ) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onSignupError(String error){
        if (loginView != null ) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}
