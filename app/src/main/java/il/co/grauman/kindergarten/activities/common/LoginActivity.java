package il.co.grauman.kindergarten.activities.common;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import il.co.grauman.kindergarten.R;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.models.exceptions.LoginFailedException;
import il.co.grauman.kindergarten.services.AuthService;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout usernameInput;
    private EditText username;
    private TextInputLayout passwordInput;
    private EditText password;
    private Button loginButton;
    private TextWatcher validateListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //noinspection ResultOfMethodCallIgnored
            validateInputs();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUIElements();
        setupOnClickListeners();

    }


    private void setupUIElements() {
        usernameInput = findViewById(R.id.usernameInput);
        username = findViewById(R.id.username);
        passwordInput = findViewById(R.id.passwordInput);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);


        // for every text change should validate the inputs
        username.addTextChangedListener(validateListener);
        password.addTextChangedListener(validateListener);
    }

    private void setupOnClickListeners() {
        loginButton.setOnClickListener(v -> {
            if (validateInputs()) {
                // TODO: display loader


                try {
                    AuthService.loginWith(this, username.getText().toString(), password.getText().toString(), this::onLoginSucceed);
                } catch (LoginFailedException e) {
                    //TODO: show error to the user
                    onLoginFailed(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * check if the username/password is in the correct format
     * clietn validation
     *
     * @return true if valid
     */
    private boolean validateInputs() {
        // TODO: check username validation
        // TODO: check password validation

        // TODO: if it's not valid input use the TextInputLayout to display the error
         usernameInput.setError("username must be less than 25");
        return true;
    }

    public void onLoginSucceed(User user) {
        // login succeeded, session saved
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void onLoginFailed(String errorMessage) {
        // TODO: hide loader
        // TODO: show error
        Toast.makeText(this, errorMessage,Toast.LENGTH_LONG).show();

    }
}
