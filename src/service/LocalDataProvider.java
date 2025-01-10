package service;

import model.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LocalDataProvider implements IDataProvider {
    private final List<Question> questions;
    private final Random random = new Random();
    private static final Logger logger = LogManager.getLogger(LocalDataProvider.class);

    public LocalDataProvider() {
        questions = new ArrayList<>();

        Map<String, Boolean> answers = new HashMap<>();
        answers.put("Berlin", false);
        answers.put("Madrid", false);
        answers.put("Paris", true);
        answers.put("Rome", false);
        questions.add(
                new Question("Capitale de la France?", answers)
        );

        answers = new HashMap<>();
        answers.put("Amazonie", true);
        answers.put("Sahara", false);
        answers.put("Gobi", false);
        answers.put("Kalahari", false);
        questions.add(
                new Question("Quel est le plus grand desert tropical du monde?", answers)
        );

        answers = new HashMap<>();
        answers.put("Royaume-Uni", false);
        answers.put("Canada", true);
        answers.put("Australie", false);
        answers.put("Etats-Unis", false);
        questions.add(
                new Question("Quel pays a la plus grande superficie au monde?", answers)
        );

        answers = new HashMap<>();
        answers.put("Himalaya", true);
        answers.put("Andes", false);
        answers.put("Alpes", false);
        answers.put("Pyrenees", false);
        questions.add(
                new Question("Quel est le plus haut massif montagneux du monde?", answers)
        );

        answers = new HashMap<>();
        answers.put("Mongolie", false);
        answers.put("Australie", false);
        answers.put("Libye", true);
        answers.put("Egypte", false);
        questions.add(
                new Question("Quel pays a le plus grand desert chaud du monde, le Sahara?", answers)
        );

        answers = new HashMap<>();
        answers.put("Lac Titicaca", true);
        answers.put("Lac Baïkal", false);
        answers.put("Lac Victoria", false);
        answers.put("Lac de Côme", false);
        questions.add(
                new Question("Quel lac se trouve a la frontiere entre le Perou et la Bolivie?", answers)
        );

        answers = new HashMap<>();
        answers.put("Etats-Unis", false);
        answers.put("France", true);
        answers.put("Canada", false);
        answers.put("Bresil", false);
        questions.add(
                new Question("Dans quel pays se trouve le Mont Saint-Michel?", answers)
        );

        answers = new HashMap<>();
        answers.put("Australie", false);
        answers.put("Inde", true);
        answers.put("Afrique du Sud", false);
        answers.put("Chine", false);
        questions.add(
                new Question("Quel pays abrite le Taj Mahal?", answers)
        );

        answers = new HashMap<>();
        answers.put("Mer de Chine", false);
        answers.put("Ocean Atlantique", false);
        answers.put("Mer Mediterranee", true);
        answers.put("Ocean Indien", false);
        questions.add(
                new Question("Quel est le nom de la mer qui borde la France et l'Italie?", answers)
        );
        answers = new HashMap<>();
        answers.put("New York", false);
        answers.put("Los Angeles", false);
        answers.put("Washington D.C.", true);
        answers.put("Chicago", false);
        questions.add(
                new Question("Quelle est la capitale des Etats-Unis?", answers)
        );

        answers = new HashMap<>();
        answers.put("Riviere du Nil", false);
        answers.put("Amazon", true);
        answers.put("Yangtse", false);
        answers.put("Mississippi", false);
        questions.add(
                new Question("Quel est le plus long fleuve du monde?", answers)
        );

        answers = new HashMap<>();
        answers.put("Europe", false);
        answers.put("Afrique", true);
        answers.put("Asie", false);
        answers.put("Oceanie", false);
        questions.add(
                new Question("Sur quel continent se trouve l'Egypte?", answers)
        );

        answers = new HashMap<>();
        answers.put("Canada", false);
        answers.put("Bresil", false);
        answers.put("Norvege", true);
        answers.put("Suede", false);
        questions.add(
                new Question("Quel pays est connu pour ses fjords et sa capitale Oslo?", answers)
        );

        answers = new HashMap<>();
        answers.put("Le Grand Canyon", true);
        answers.put("Les Chutes du Niagara", false);
        answers.put("Les Pyramides de Gizeh", false);
        answers.put("La Tour Eiffel", false);
        questions.add(
                new Question("Quel est le nom de la celebre gorge situee aux Etats-Unis?", answers)
        );

        answers = new HashMap<>();
        answers.put("Lac de Garde", false);
        answers.put("Lac Leman", false);
        answers.put("Lac Baïkal", true);
        answers.put("Lac Titicaca", false);
        questions.add(
                new Question("Quel est le lac le plus profond du monde?", answers)
        );

        answers = new HashMap<>();
        answers.put("Perou", false);
        answers.put("Bolivie", false);
        answers.put("Chili", true);
        answers.put("Argentine", false);
        questions.add(
                new Question("Quel pays possede le desert d'Atacama?", answers)
        );

        answers = new HashMap<>();
        answers.put("L'Inde", false);
        answers.put("Le Pakistan", false);
        answers.put("Le Nepal", true);
        answers.put("La Chine", false);
        questions.add(
                new Question("Quel pays abrite la montagne du Mont Everest?", answers)
        );

        answers = new HashMap<>();
        answers.put("Cap Horn", false);
        answers.put("Cap de Bonne-Esperance", true);
        answers.put("Cap des Tempêtes", false);
        answers.put("Cap Nord", false);
        questions.add(
                new Question("Quel est le nom du cap situe a l'extremite sud de l'Afrique?", answers)
        );

        answers = new HashMap<>();
        answers.put("Marrakech", true);
        answers.put("Casablanca", false);
        answers.put("Rabat", false);
        answers.put("Tanger", false);
        questions.add(
                new Question("Quelle ville est la capitale touristique du Maroc?", answers)
        );
    }

    @Override
    public Question getRandomQuestion() {
        if (questions == null || questions.isEmpty()) {
            throw new IllegalStateException("No questions available.");
        }

        logger.info("getting a local question");
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }
}
