package br.com.hebaja.phrasalverbsquiz.ui;

public class QuestionsLibraryView {

    private String questions [] = {
            "1. The dog went for him.",
            "2. She hadn't bargained for this.",
            "3. It suddenly dawned on her.",
            "4. I feel for you.",
            "5. She got over her illness.",
            "6. The police looked into it.",
            "7. They talked it over.",
            "8. She did up her laces.",
            "9. He called on her.",
            "10. She made for the living room.",
            "11. He launched into a long speech.",
            "12. He takes after his mother.",
            " "
    };

    private String options [][] = {
            {"a) The dog barked at him.","b) The dog attacked him.","c) The dog followed him."},
            {"a) She hadn't expected this.","b) She hadn't bought this.","c) She hadn't profited from this."},
            {"a) She suddenly turned the lights on.","b) She suddenly realised.","c) She was suddenly seen."},
            {"a) I am fond of you.","b) I pity you.","c) I sympathise for you."},
            {"a) She learned from her ilness.","b) She died from her ilness.","c) She recovered from her illness."},
            {"a) The police didn't care about it.","b) The police ivestigated it.","c) The police looked inside it."},
            {"a) They discussed it.","b) They talked a lot.","c) They gossiped."},
            {"a) She tied her laces.","b) She painted her laces.","c) She sewed her laces."},
            {"a) He telephoned her.","b) He visited her.","c) He blamed her."},
            {"a) She went towards the living room.","b) She paid to build the living room.","c) She decorated the living room."},
            {"a) He improvised a long speech.","b) He got lost in his long speech.","c) He began a long speech."},
            {"a) He has the same profession as his mother.","b) He looks like his mother.","c) He is like his mother."},
            {" "," "," "}

};

//    private String rightAnswers [] = {"b","a","b","c","c","b","a","a","b","a","c","c"};

    private int rightAnswersPositions [] = {1,0,1,2,2,1,0,0,1,0,2,2,3};

    public String getQuestions(int position) {
        String question = questions[position];
        return question;
    }

    public String getOptionA (int position) {
        String optionA = options[position][0];
        return optionA;
    }

    public String getOptionB (int position) {
        String optionB = options[position][1];
        return optionB;
    }

    public String getOptionC (int position) {
        String optionC = options[position][2];
        return optionC;
    }

//    public String getRightAnswer (int position) {
//        String rightAnswer = rightAnswers[position];
//        return rightAnswer;
//    }

    public int getRightAnswerPosition (int position) {
        int rightAnswerPosition = rightAnswersPositions[position];
        return rightAnswerPosition;
    }



}
