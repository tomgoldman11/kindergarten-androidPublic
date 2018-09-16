package il.co.grauman.kindergarten.activities.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.bl.login.UserUpdate;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                UserUpdate.getInstance().userLogin(username.getText().toString(), password.getText().toString(), new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        User tempUser = response.body();
                        SPref.getInstance().putString(Constants.USERNAME, username.getText().toString());
                        SPref.getInstance().putInt(Constants.ROLE, tempUser.getCategory().ordinal());
                        LoginActivity.this.onLoginSucceed();
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        LoginActivity.this.onLoginFailed(t.getMessage());
                    }
                });

            }
        });
    }

    /**
     * check if the username/password is in the correct format
     * client validation
     *
     * @return true if valid
     */
    private boolean validateInputs() {
        // check username validation
        if (username.getText().toString().length() < getResources().getInteger(R.integer.min_username) ||
                username.getText().toString().length() > getResources().getInteger(R.integer.max_username)) {
            usernameInput.setError(getString(R.string.username_error, getResources().getInteger(R.integer.min_username), getResources().getInteger(R.integer.max_username)));
            return false;
        } else {
            usernameInput.setError(null);
        }
        // check password validation
        if (password.getText().toString().length() < getResources().getInteger(R.integer.min_password) ||
                password.getText().toString().length() > getResources().getInteger(R.integer.max_password)) {
            passwordInput.setError(getResources().getString(R.string.password_error,
                    getResources().getInteger(R.integer.min_password),
                    getResources().getInteger(R.integer.max_password)));
            return false;
        } else {
            passwordInput.setError(null);
        }

        return true;
    }

    public void onLoginSucceed() {
        // login succeeded, session saved
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void onLoginFailed(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();

    }
}
