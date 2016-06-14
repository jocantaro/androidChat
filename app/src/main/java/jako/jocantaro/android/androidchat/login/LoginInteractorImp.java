package jako.jocantaro.android.androidchat.login;

/**
 * Created by Jocantaro on 10/06/2016.
 */
public class LoginInteractorImp implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImp (){
        loginRepository = new LoginRepositoryImp();
    }

    @Override
    public void checkSession() {
        loginRepository.checkAlreadyAuthenticated();
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRepository.signUp(email,password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email,password);
    }
}
