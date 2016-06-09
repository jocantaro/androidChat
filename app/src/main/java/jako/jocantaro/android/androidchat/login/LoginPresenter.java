package jako.jocantaro.android.androidchat.login;

public interface LoginPresenter {

    void onDestroy(); //como la vista va a ser un actividad, para evitar problemos, a la hora de destruir la vista tenemos que destruir tambi'en la variable que mandamos al presentador
    void checkForAuthenticatedUser(); //si existe sesi'on abierta
    void validateLogin (String email, String password);
    void registerNewUser (String email, String password);
}
