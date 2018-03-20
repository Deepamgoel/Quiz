package com.example.deepamgoel.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout sign_in_panel;
    private TextView signUp_header;
    private EditText email_id;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void signUpButton(View view) {
        sign_in_panel = findViewById(R.id.buttonPanel);
        sign_in_panel.setVisibility(View.INVISIBLE);

        signUp_header = findViewById(R.id.sign_in_header_text);
        signUp_header.setText(R.string.sign_up);

        signUpButton = findViewById(R.id.sign_up_button_2);
        signUpButton.setVisibility(View.VISIBLE);

        email_id = findViewById(R.id.email_id);
        email_id.setVisibility(View.VISIBLE);
    }

    public void signUp(View view) {

        email_id = findViewById(R.id.email_id);
        String empty_email = email_id.getText().toString();

        EditText username = findViewById(R.id.username);
        String empty_username = username.getText().toString();


        if (TextUtils.isEmpty(empty_email) && TextUtils.isEmpty(empty_username)) {
            email_id.setError("Invalid Input");
            username.setError("Invalid Input");
        } else if (TextUtils.isEmpty(empty_email)) {
            email_id.setError("Invalid Input");
        } else if (TextUtils.isEmpty(empty_username)) {
            username.setError("Invalid Input");
        } else {
            signUp_header = findViewById(R.id.sign_in_header_text);
            sign_in_panel = findViewById(R.id.buttonPanel);
            signUpButton = findViewById(R.id.sign_up_button_2);

            signUp_header.setText(R.string.sign_in);
            signUpButton.setVisibility(View.INVISIBLE);
            sign_in_panel.setVisibility(View.VISIBLE);
            email_id.setVisibility(View.INVISIBLE);
        }
    }


    public void signIn(View view) {
        Intent openOtherActivity = new Intent(this, Quiz.class);
        startActivity(openOtherActivity);
    }


}
