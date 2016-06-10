package jako.jocantaro.android.androidchat.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jako.jocantaro.android.androidchat.R;
import jako.jocantaro.android.androidchat.contactList.ContactListActivity;
import jako.jocantaro.android.androidchat.login.LoginPresenter;
import jako.jocantaro.android.androidchat.login.LoginPresenterImp;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.inputEditTXT_Name)
    EditText inputEditTXTName;
    @Bind(R.id.wrapper_name)
    TextInputLayout wrapperName;
    @Bind(R.id.inputEditTXT_Pass)
    EditText inputEditTXTPass;
    @Bind(R.id.wrapper_password)
    TextInputLayout wrapperPassword;
    @Bind(R.id.btn_singIn)
    Button btnSingIn;
    @Bind(R.id.btn_singUp)
    Button btnSingUp;
    @Bind(R.id.layout_buttom)
    LinearLayout layoutButtom;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.container)
    RelativeLayout container;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImp(this);
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticatedUser();

    }

    @OnClick({R.id.btn_singIn, R.id.btn_singUp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_singIn:
                handleSignIn();
                break;
            case R.id.btn_singUp:
                handleSignUp();
                break;
        }
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        loginPresenter.onDestroy();

    }

    @Override
    public void enableInputs() {
        setInputs (true);

    }

    @Override
    public void disableInputs() {
        setInputs(false);

    }

    @Override
    public void showProgress() {
        progressbar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressbar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void handleSignUp() {
        loginPresenter.registerNewUser(inputEditTXTName.getText().toString(),
                inputEditTXTPass.getText().toString());

    }

    @Override
    public void handleSignIn() {
        loginPresenter.validateLogin(inputEditTXTName.getText().toString(),
                inputEditTXTPass.getText().toString());
    }

    @Override
    public void navigateToMainScreen() {

        Intent i = new Intent(this, ContactListActivity.class);
        startActivity(i);
    }

    @Override
    public void loginError(String error) {
        inputEditTXTPass.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signIn),error);
        inputEditTXTPass.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(container,R.string.login_notice_message_signIn,Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void newUserError(String error) {
        inputEditTXTPass.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signUp),error);
        inputEditTXTPass.setError(msgError);
    }

    private void setInputs (boolean enabled){

        inputEditTXTName.setEnabled(enabled);
        inputEditTXTPass.setEnabled(enabled);
        btnSingIn.setEnabled(enabled);
        btnSingUp.setEnabled(enabled);


    }
}
