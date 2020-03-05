package br.com.hebaja.phrasalverbsquiz.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.hebaja.phrasalverbsquiz.R;
import br.com.hebaja.phrasalverbsquiz.model.Question;

public class PhrasalVerbsQuizAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public void setScannerQuestions() throws FileNotFoundException {

        ArrayList<Question> questions = new ArrayList<>();

        Scanner scannerQuestionsOptions = new Scanner(new File("R.raw.questions"));

        Scanner scannerRightAnswers = new Scanner(new File(String.valueOf(R.raw.questions_answers)));

        while(scannerQuestionsOptions.hasNextLine()) {

            String lineQuestionOptions = scannerQuestionsOptions.next();

            Scanner format = new Scanner(lineQuestionOptions);

            format.useDelimiter(",");

            Question question = new Question();

            String linePrompt = format.next();
            question.setPrompt(linePrompt);
            String lineOptiopnA = format.nextLine();
            question.setOptionA(lineOptiopnA);
            String lineOptiopnB = format.nextLine();
            question.setOptionB(lineOptiopnB);
            String lineOptiopnC = format.nextLine();
            question.setOptionC(lineOptiopnC);

        }
    }
}
