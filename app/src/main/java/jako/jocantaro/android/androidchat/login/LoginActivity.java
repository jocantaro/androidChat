package jako.jocantaro.android.androidchat.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jako.jocantaro.android.androidchat.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

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

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_singIn, R.id.btn_singUn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_singIn:
                handleSignIn();
                break;
            case R.id.btn_singUn:
                handleSignUp();
                break;
        }
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
    public void navigateToMainScree() {

    }

    @Override
    public void loginError(String error) {

    }

    @Override
    public void newUserSuccess() {

    }

    @Override
    public void newUserError(String error) {

    }

    private void setInputs (boolean enabled){

        inputEditTXTName.setEnabled(enabled);
        inputEditTXTPass.setEnabled(enabled);
        btnSingIn.setEnabled(enabled);
        btnSingUp.setEnabled(enabled);


    }
}
