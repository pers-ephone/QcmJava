package service;

import model.Question;

public class LocalGameDisplay implements IGameDisplay {
    @Override
    public void displayQuestion(Question question) {
        System.out.println(question.getText());
        for(String answer : question.getAnswers()) {
            System.out.println(answer);
        }
    }

    @Override
    public void displayEnd(int score) {
        System.out.println("You got a total of " + score + " points");
    }
}
