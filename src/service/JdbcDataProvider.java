package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JdbcDataProvider implements IDataProvider {
    private final Connection connection;
    private static final Logger logger = LogManager.getLogger(JdbcDataProvider.class);

    public JdbcDataProvider() {
        this.connection = ConnectionJdbc.getConnection();
    }
    
    @Override
    public Question getRandomQuestion() {
        Statement stmt = null;
        String questionText;
        Map<String, Boolean> answers = new HashMap<>();
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();

            // get random question
            rs = stmt.executeQuery("SELECT * FROM question ORDER BY RAND() LIMIT 1");
            rs.next();
            questionText = rs.getString("question");
            int id = rs.getInt("id");

            // get answers
            rs = stmt.executeQuery("SELECT answer, isCorrect FROM answer WHERE idQuestion = " + id);
            while (rs.next()) {
                answers.put(
                        rs.getString("answer"),
                        rs.getBoolean("isCorrect")
                );
            }
            logger.info("queried a question");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new Question(questionText, answers);
    }
}
