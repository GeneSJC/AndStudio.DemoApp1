package com.demo.samples2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.samples2.R;


public class SignInActivity extends Activity {

    // UI references.
    private EditText usernameView;
    private EditText passwordView;
    private EditText passwordConfirmView;

    private boolean isLoginState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameView = (EditText) findViewById(R.id.username);
        passwordView = (EditText) findViewById(R.id.password);
        passwordConfirmView = (EditText) findViewById(R.id.password_confirm);

        setLoginButtonAndLink();
    }


    private void setLoginButtonAndLink() {

        final Button signInButton = (Button) findViewById(R.id.sign_in_button);
        final TextView linkTextView = (TextView) findViewById(R.id.linkText);

        linkTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                toggleLoginState(signInButton, linkTextView);
            }
        });

        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                attemptLoginOrRegister();
            }
        });
    }

    private void toggleLoginState(final Button signInButton, final TextView linkTextView) {

        if (isInLoginState()) {

            isLoginState = false;

            signInButton.setText("Register");
            linkTextView.setText("Login");

            passwordConfirmView.setVisibility(View.VISIBLE);

            return;
        }

        isLoginState = true;

        signInButton.setText("Login");
        linkTextView.setText("Register");

        passwordConfirmView.setVisibility(View.GONE);
    }


    private boolean isInRegisterState()
    {
        return ( ! isInLoginState() );
    }

    private boolean isInLoginState()
    {
        return isLoginState;
    }

    private void resetViewErrors() {

        usernameView.setError(null);
        passwordView.setError(null);
    }

    private void attemptLoginOrRegister() {


    }

}