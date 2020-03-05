package br.com.hebaja.phrasalverbsquiz.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.hebaja.phrasalverbsquiz.R;
import br.com.hebaja.phrasalverbsquiz.model.Question;
import br.com.hebaja.phrasalverbsquiz.ui.QuestionsLibraryView;

public class PhrasalVerbsQuizActivity extends Activity {

    //Get the questions, options and right answers strings
    private QuestionsLibraryView questionsLibrary = new QuestionsLibraryView();

    //Create an list of questions to be populated by the method createQuestionsObjects();
    ArrayList<Question> questions = new ArrayList<>();

    private TextView textViewQuestion;
    private TextView scoreView;
    private Button buttonOptionA;
    private Button buttonOptionB;
    private Button buttonOptionC;

    private int rightAnswer;

    private int score = 0;

    private int position = 0;

    private int optionPostionA;
    private int optionPostionB;
    private int optionPostionC;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrasal_verbs_quiz);

        textViewQuestion = (TextView)findViewById(R.id.id_question);
        scoreView = (TextView)findViewById(R.id.score_counter);
        buttonOptionA = (Button)findViewById(R.id.button_option_a);
        buttonOptionB = (Button)findViewById(R.id.button_option_b);
        buttonOptionC = (Button)findViewById(R.id.button_option_c);

        createQuestionsObjects();

        updateQuestions();

//        try {
//            getScanner();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        buttonOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionPostionA == rightAnswer) {
                    score++;
                    updateScore(score);
                    updateQuestions();
                    Toast.makeText(PhrasalVerbsQuizActivity.this, "Right Answer", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PhrasalVerbsQuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    updateQuestions();
                }
            }
        });

        buttonOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionPostionB == rightAnswer) {
                    score++;
                    updateScore(score);
                    updateQuestions();
                    Toast.makeText(PhrasalVerbsQuizActivity.this, "Right Answer", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PhrasalVerbsQuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    updateQuestions();
                }
            }
        });

        buttonOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optionPostionC == rightAnswer) {
                    score++;
                    updateScore(score);
                    updateQuestions();
                    Toast.makeText(PhrasalVerbsQuizActivity.this, "Right Answer", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PhrasalVerbsQuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    updateQuestions();
                }
            }
        });

    }

    private void createQuestionsObjects() {
        for(int i = 0; i < 13; i++) {
            Question question = new Question();
            question.setPrompt(questionsLibrary.getQuestions(i));
            question.setOptionA(questionsLibrary.getOptionA(i));
            question.setOptionB(questionsLibrary.getOptionB(i));
            question.setOptionC(questionsLibrary.getOptionC(i));
            questions.add(question);
        }
    }

    private void updateQuestions() {
        textViewQuestion.setText(questions.get(position).getPrompt());
        buttonOptionA.setText(questions.get(position).getOptionA());
        buttonOptionB.setText(questions.get(position).getOptionB());
        buttonOptionC.setText(questions.get(position).getOptionC());

        optionPostionA = 0;
        optionPostionB = 1;
        optionPostionC = 2;

        rightAnswer = questionsLibrary.getRightAnswerPosition(position);
        position++;

    }

    private void updateScore(int point) {
        scoreView.setText("" + score);
    }

    private void getScanner() throws FileNotFoundException {



//        Scanner scanner = new Scanner(new File("/home/focus/AndroidStudioProjects/PhrasalVerbsQuiz/app/questions.csv"));
//        String line = scanner.next();
//        Log.i("checking", "getScanner: " + line);

    }
}
