package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;

    TextView textViewReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textViewReply = (TextView) findViewById(R.id.textViewReply);
        textViewReply.setVisibility(View.INVISIBLE);

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
    }

    public void signupPressed(View view){

        if (usernameEditText.getText().toString().matches("") && passwordEditText.getText().toString().matches("")){
            Toast.makeText(SignupActivity.this, "Email and Password can not be blank.", Toast.LENGTH_SHORT).show();
            textViewReply.setText("Email and Password can not be blank.");
            textViewReply.setVisibility(View.VISIBLE);
        } else signUP(usernameEditText.getText().toString(), passwordEditText.getText().toString());
    }

    private void signUP(String userName, String passWord){

        ParseUser user = new ParseUser();
        user.setUsername(userName + "@aai.aero");
        user.setPassword(passWord);
        user.setEmail(userName + "@aai.aero");

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignupActivity.this, "User successfully created. Please verify your email.", Toast.LENGTH_LONG).show();
                    Log.i("Parse User"," Successfully Created");
                    textViewReply.setText("User successfully created. Please verify your email.");
                    textViewReply.setTextColor(Color.GREEN);
                    textViewReply.setVisibility(View.VISIBLE);

                } else {
                    Log.i("Parse User"," not Created due to "+ e);
                    textViewReply.setText(e.getMessage());
                    textViewReply.setVisibility(View.VISIBLE);
                    Toast.makeText(SignupActivity.this, " "+e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void loginPageClicked(View view){

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }
}