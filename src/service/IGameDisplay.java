package service;

import model.Question;

public interface IGameDisplay {
    void displayQuestion(Question question);

    void displayEnd(int score);
}
