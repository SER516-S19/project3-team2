import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;


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
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonContentObject = new JsonObject();
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            jsonContentObject = jsonParser.parse(jsonString).getAsJsonObject();
            JsonArray contentArray = jsonContentObject.get(ConstantTable.QUIZ_IDENTIFIER).getAsJsonArray();

            for (JsonElement questionElem : contentArray) {
                JsonObject questionJsonObj = questionElem.getAsJsonObject();
                JsonArray optionsArray = (JsonArray) questionJsonObj.get(ConstantTable.QUESTION_OPTIONS).getAsJsonArray();

                String title = (String) questionJsonObj.get(ConstantTable.QUESTION_TITLE).getAsString();
                ArrayList<String> optionsInThisQuestion = new ArrayList<String>();
                String correctAnswer = (String) questionJsonObj.get(ConstantTable.QUESTION_CORRECT_ANSWER).getAsString();

                for (JsonElement elem: optionsArray) {
                    String optionStr = (String) elem.getAsString();
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

    public static String getQuestionsJsonString(List<Question> questions) {
        JsonObject resultObject = new JsonObject();
        JsonArray allQuestions = new JsonArray();

        for (Question question: questions) {
            JsonObject questionJsonObj = new JsonObject();
            questionJsonObj.add(ConstantTable.QUESTION_TITLE, new JsonPrimitive(question.getTitle()));
            questionJsonObj.add(ConstantTable.QUESTION_CORRECT_ANSWER, new JsonPrimitive(question.getCorrectAnswer()));
            JsonArray optionsArray = new JsonArray();
            for (String optionStatement: question.getOptions()) {
                optionsArray.add(new JsonPrimitive(optionStatement));
            }
            questionJsonObj.add(ConstantTable.QUESTION_OPTIONS, optionsArray);
            allQuestions.add(questionJsonObj);
        }

        resultObject.add(ConstantTable.QUIZ_IDENTIFIER, allQuestions);

        return resultObject.toString();
    }

    public static void main(String[] args) {
        String jsonString = getStrFromFile("/Users/meng/test.json");
        System.out.println(jsonString);
        List<Question> questions = getQuestionsFromJsonString(jsonString);
        String jsonStringResult = getQuestionsJsonString(questions);

        System.out.println(jsonStringResult);
    }
}
