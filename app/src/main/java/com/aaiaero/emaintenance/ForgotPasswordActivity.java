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

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

import java.util.ArrayList;
import java.util.List;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText editText;
    TextView textViewReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editText = (EditText) findViewById(R.id.usernameEditText);

        textViewReply = (TextView) findViewById(R.id.textViewReply);
        textViewReply.setVisibility(View.INVISIBLE);

    }

    public void sendResetPasswordPressed(View view){

        if (editText.getText().toString().matches("")){
            textViewReply.setText("Please enter email to reset password.");
            textViewReply.setVisibility(View.VISIBLE);
            Toast.makeText(ForgotPasswordActivity.this, "Please enter email to reset password.", Toast.LENGTH_SHORT).show();
        } else resetPassword(editText.getText().toString());

    }

    public void loginPageClicked(View view){

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

    private void resetPassword(String userName){
        ParseUser.requestPasswordResetInBackground(userName + "@aai.aero", new RequestPasswordResetCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    textViewReply.setText("An email was successfully sent with reset instructions.");
                    textViewReply.setTextColor(Color.GREEN);
                    textViewReply.setVisibility(View.VISIBLE);
                    Log.i("Passwprd Reset " , "An email was successfully sent with reset instructions.");
                    Toast.makeText(ForgotPasswordActivity.this, "An email was successfully sent with reset instructions.", Toast.LENGTH_SHORT).show();
                } else {
                    textViewReply.setText(e.getMessage());
                    textViewReply.setVisibility(View.VISIBLE);
                    Toast.makeText(ForgotPasswordActivity.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();

                    // Something went wrong. Look at the ParseException to see what's up.
                }
            }
        });
    }
}