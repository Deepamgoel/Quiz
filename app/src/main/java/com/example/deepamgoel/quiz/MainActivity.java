package com.example.deepamgoel.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signUp(View view) {
        Intent openOtherActivity = new Intent(this, SignUp.class);
        startActivity(openOtherActivity);
    }

    public void signIN(View view) {
        Intent openOtherActivity = new Intent(this, Quiz.class);
        startActivity(openOtherActivity);
    }
}
