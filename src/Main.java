import model.Question;
import service.IGameDisplay;
import service.IQuestionsProvider;
import service.LocalGameDisplay;
import service.JdbcQuestionsProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IQuestionsProvider questionsProvider = new JdbcQuestionsProvider();
        IGameDisplay display = new LocalGameDisplay();
        int score = 0;

        // Game loop
        System.out.println("Démarrage du quiz: 5 questions");
        for (int i = 0; i < 5; i++) {
            Question question = questionsProvider.getRandomQuestion();

            display.displayQuestion(question);

            // ask and check answer
            if (question.isCorrect(
                    scanner.nextLine()
            )) {
                score ++;
                System.out.println("Bonne réponse");
            } else System.out.println("Mauvaise réponse");
        }

        display.displayEnd(score);
    }
}
