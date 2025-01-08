package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question {
    private final String text;
    private final Map<String, Boolean> answers;

    public Question(String questionText, Map<String, Boolean> answers) {
        if (answers == null || answers.size() < 2) {
            throw new IllegalArgumentException("A question must have at least two answers.");
        }

        this.text = questionText;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public List<String> getAnswers() {
        return new ArrayList<>(answers.keySet());
    }

    public boolean isCorrect(String answer) {
        String lowerAnswer = answer.toLowerCase();

        for(String key : answers.keySet()) {
            if(key.toLowerCase().equals(lowerAnswer)) {
                return true;
            }
        }
        return false;
    }
}
