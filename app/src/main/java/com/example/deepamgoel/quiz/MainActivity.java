package com.example.deepamgoel.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String[] questions = {
            "Which one was the first search Engine on internet?",
            "No of bits used in IPv6?",
            "Which is the first computer virus?",
            "Which programming language is exclusively used for AI?",
            "A dual layer Blue-Ray Disk can store data up-to?"
    };

    String[][] options = {
            {"Google", "Archie Virus", "WAIS", "Altavista"},
            {"32 bit", "64 bit", "128 bit", "256 bit"},
            {"Rabbit", "Creeper Virus", "Elk Cloner", "SCA Virus"},
            {"C", "Java", "J2EE", "Prolog"},
            {"20GB", "35GB", "12GB", "50GB"}
    };

    String[] answers = {
            "Archie Virus",
            "128 bit",
            "Creeper Virus",
            "Prolog",
            "50GB"
    };


    int questionNumber = 0, totalQuestions = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i = questionNumber;

        TextView questionNo = findViewById(R.id.questionNo);
        TextView question = findViewById(R.id.question);
        Button option1 = findViewById(R.id.opt1);
        Button option2 = findViewById(R.id.opt2);
        Button option3 = findViewById(R.id.opt3);
        Button option4 = findViewById(R.id.opt4);

        questionNo.setText(String.format(Locale.getDefault(), "Question: %d/%d",i+1, totalQuestions));
        question.setText(questions[i]);
        option1.setText(options[i][0]);
        option2.setText(options[i][1]);
        option3.setText(options[i][2]);
        option4.setText(options[i][3]);
    }

    public void next(View view) {

        questionNumber++;
        if(questionNumber==totalQuestions)
            questionNumber=totalQuestions-1;

        int i = questionNumber;

        TextView questionNo = findViewById(R.id.questionNo);
        TextView question = findViewById(R.id.question);
        Button option1 = findViewById(R.id.opt1);
        Button option2 = findViewById(R.id.opt2);
        Button option3 = findViewById(R.id.opt3);
        Button option4 = findViewById(R.id.opt4);

        questionNo.setText(String.format(Locale.getDefault(), "Question: %d/%d", i+1, totalQuestions));
        question.setText(questions[i]);
        option1.setText(options[i][0]);
        option2.setText(options[i][1]);
        option3.setText(options[i][2]);
        option4.setText(options[i][3]);

        option1.setBackgroundResource(R.drawable.background);
        option2.setBackgroundResource(R.drawable.background);
        option3.setBackgroundResource(R.drawable.background);
        option4.setBackgroundResource(R.drawable.background);
    }

    public void previous(View view) {

        questionNumber--;
        if(questionNumber<0)
            questionNumber=0;
        int i = questionNumber;

        TextView questionNo = findViewById(R.id.questionNo);
        TextView question = findViewById(R.id.question);
        Button option1 = findViewById(R.id.opt1);
        Button option2 = findViewById(R.id.opt2);
        Button option3 = findViewById(R.id.opt3);
        Button option4 = findViewById(R.id.opt4);

        questionNo.setText(String.format(Locale.getDefault(), "Question: %d/%d", i+1, totalQuestions));
        question.setText(questions[i]);
        option1.setText(options[i][0]);
        option2.setText(options[i][1]);
        option3.setText(options[i][2]);
        option4.setText(options[i][3]);

        option1.setBackgroundResource(R.drawable.background);
        option2.setBackgroundResource(R.drawable.background);
        option3.setBackgroundResource(R.drawable.background);
        option4.setBackgroundResource(R.drawable.background);


    }

    public void validate(View view) {
        int i = questionNumber;
        Button pressed = findViewById(view.getId());
        if(pressed.getText()==answers[i])
        {
            pressed.setBackgroundResource(R.drawable.backgroundcorrect);

        }
        else
        {
            pressed.setBackgroundResource(R.drawable.backgroundwrong);
        }

    }
}
