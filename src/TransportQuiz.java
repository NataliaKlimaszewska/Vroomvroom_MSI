import java.util.LinkedHashMap;
import java.util.Map;

public class TransportQuiz {
    private static class Questions {
        String question;
        Map<String, String> options;

        Questions(String question, Map<String, String> options) {
            this.question = question;
            this.options = options;
        }
    }

    private static final Map<Integer, Questions> questions = new LinkedHashMap<>();

    private static void QuestionSet(){

        Map<String,String> options = new LinkedHashMap<>();
        options.put ("1", "Tak");
        options.put ("2", "Nie");

    }
}
