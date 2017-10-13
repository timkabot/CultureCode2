package com.example.timkabor.culturecode.view.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.timkabor.culturecode.Constants;
import com.example.timkabor.culturecode.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Timkabor on 10/13/2017.
 */

import android.app.ProgressDialog;
import android.util.Log;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.link_signup) TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkInfo();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(v -> login());

    }
    public void checkInfo() {
        SharedPreferences sPref;
        sPref = getSharedPreferences("",MODE_PRIVATE);
        if(sPref.contains("login")) {
            goNextPage();
        }
    }
    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String login = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.
        Constants c = new Constants();

        new android.os.Handler().postDelayed(
                () -> {
                    // On complete call either onLoginSuccess or onLoginFailed
                    boolean found = false;
                    for(int i=0;i<c.getAccounts().size();i++)
                    {
                        System.out.println(c.getAccounts().get(i).getLogin() + " " + c.getAccounts().get(i).getPassword());
                        if(login.equals(c.getAccounts().get(i).getLogin()) && password.equals(c.getAccounts().get(i).getPassword())) {
                            found = true;
                            break;
                        }
                    }
                    if(found) onLoginSuccess(login,password);
                    else onLoginFailed();
                    progressDialog.dismiss();
                }, 1000);
    }



    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }
    public void goNextPage() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void onLoginSuccess(String login, String password) {
        _loginButton.setEnabled(true);
        SharedPreferences sPref;
        sPref = getSharedPreferences("",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("login",login);
        ed.putString("password",password);
        ed.commit();
        goNextPage();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError("enter a valid login please");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}
