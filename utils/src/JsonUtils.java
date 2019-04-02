import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonUtils {
    public static String getStrFromFile(String absoluteFilename) {
        String content = "";

        try {
            Scanner inputStream = new Scanner(new File(absoluteFilename));
            while (inputStream.hasNextLine()) {
                content = content + inputStream.nextLine();
            }
        } catch (FileNotFoundException fe) {
            System.out.println(fe);
        }

        return content;
    }

    public static List<Question> getQuestionsFromJsonString(String jsonString) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonContentObject = new JSONObject();
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            jsonContentObject = (JSONObject) jsonParser.parse(jsonString);
            JSONArray contentArray = (JSONArray) jsonContentObject.get(ConstantTable.QUIZ_IDENTIFIER);

            for (Object obj : contentArray) {
                JSONObject questionJsonObj = (JSONObject) obj;
                JSONArray optionArrays = (JSONArray) questionJsonObj.get(ConstantTable.QUESTION_OPTIONS);

                String title = (String) questionJsonObj.get(ConstantTable.QUESTION_TITLE);
                ArrayList<String> optionsInThisQuestion = new ArrayList<String>();
                String correctAnswer = (String) questionJsonObj.get(ConstantTable.QUESTION_CORRECT_ANSWER);

                for (Object optionObj: optionArrays) {
                    String optionStr = (String) optionObj;
                    optionsInThisQuestion.add(optionStr);
                }

                Question question = new Question();
                question.setTitle(title);
                question.setOptions(optionsInThisQuestion);
                question.setCorrectAnswer(correctAnswer);

                questions.add(question);
            }

            return questions;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public static void main(String[] args) {
        String jsonString = getStrFromFile("/Users/meng/test.json");
        List<Question> questions = getQuestionsFromJsonString(jsonString);
        System.out.println(questions.get(0).getCorrectAnswer());
    }
}
