import model.Question;
import service.IGameDisplay;
import service.IDataProvider;
import service.LocalGameDisplay;
import service.JdbcDataProvider;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IDataProvider questionsProvider = new JdbcDataProvider();
        IGameDisplay display = new LocalGameDisplay();
        int score = 0;
        int QNUMBER = 5;

        logger.info("starting game");
        // game loop
        System.out.println("Démarrage du quiz: " + QNUMBER + " questions");
        for (int i = 0; i < QNUMBER; i++) {
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
