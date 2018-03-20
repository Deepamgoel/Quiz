package com.example.deepamgoel.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Quiz extends AppCompatActivity {

    private static String[] questions = {
            "Which one was the first search Engine on internet?",
            "No of bits used in IPv6?",
            "Which is the first computer virus?",
            "Which programming language is exclusively used for AI?",
            "A dual layer Blue-Ray Disk can store data up-to?"
    };

    private static String[][] options = {
            {"Google", "Archie Virus", "WAIS", "Altavista"},
            {"32 bit", "64 bit", "128 bit", "256 bit"},
            {"Rabbit", "Creeper Virus", "Elk Cloner", "SCA Virus"},
            {"C", "Java", "J2EE", "Prolog"},
            {"20GB", "35GB", "12GB", "50GB"}
    };

    private static String[] answers = {
            "Archie Virus",
            "128 bit",
            "Creeper Virus",
            "Prolog",
            "50GB"
    };

    private static boolean[] answered = new boolean[questions.length];      //For storing attempted question

    private static int questionNumber = 0, totalQuestions = questions.length, result = 0;

    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;

    private void setQuestions(int questionNumber) {         //For setting Questions and their respective options in activity

        TextView questionNo = findViewById(R.id.questionNo);
        TextView question = findViewById(R.id.question);

        option1 = findViewById(R.id.opt1);
        option2 = findViewById(R.id.opt2);
        option3 = findViewById(R.id.opt3);
        option4 = findViewById(R.id.opt4);

        questionNo.setText(String.format(Locale.getDefault(), "Question: %d/%d", questionNumber + 1, totalQuestions));
        question.setText(questions[questionNumber]);
        option1.setText(options[questionNumber][0]);
        option2.setText(options[questionNumber][1]);
        option3.setText(options[questionNumber][2]);
        option4.setText(options[questionNumber][3]);

        option1.setBackgroundResource(R.drawable.background);
        option2.setBackgroundResource(R.drawable.background);
        option3.setBackgroundResource(R.drawable.background);
        option4.setBackgroundResource(R.drawable.background);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        int i = questionNumber;

        setQuestions(i);

    }

    public void validate(View view) {       //For validating pressed option
        int i = questionNumber;
        Button pressed = findViewById(view.getId());

        option1 = findViewById(R.id.opt1);
        option2 = findViewById(R.id.opt2);
        option3 = findViewById(R.id.opt3);
        option4 = findViewById(R.id.opt4);

        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);

        if (pressed.getText() == answers[i]) {
            pressed.setBackgroundResource(R.drawable.background_correct);
            result++;
        } else {
            pressed.setBackgroundResource(R.drawable.background_wrong);
        }

        answered[i] = true;
    }


    public void next(View view) {

        ++questionNumber;

        if (questionNumber == totalQuestions - 1) {
            Button result = findViewById(R.id.next);
            result.setText(R.string.result);
        }

        if (questionNumber == totalQuestions) {
            String score = R.string.score + result + "/" + totalQuestions;
            Toast.makeText(this, score, Toast.LENGTH_SHORT).show();
            questionNumber = totalQuestions - 1;
            return;
        }

        setQuestions(questionNumber);

        if (answered[questionNumber]) {

            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);

        } else {
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
        }

    }

    public void previous(View view) {

        --questionNumber;

        if (questionNumber <= 0)
            questionNumber = 0;

        if (questionNumber < totalQuestions - 1) {
            Button result = findViewById(R.id.next);
            result.setText(R.string.next);
        }

        setQuestions(questionNumber);

        if (answered[questionNumber]) {

            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);

        } else {
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
        }

    }

}
