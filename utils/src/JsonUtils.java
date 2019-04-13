package src;

/**
 * This file contains 4 static function which facilitates quiz/questions creating process.
 *	@author: Meng-Ze Chen
 *	@version: 1.0 
 *
*/

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import java.io.IOException;
import java.io.FileNotFoundException;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class JsonUtils {
	
	/**
	 * TRANSFER String into usable datastructure.
	 * @param absoluteFilepath
	 * @return
	 */
    public static String getStringFromFile(String absoluteFilepath) {
        String content = "";

        try {
            Scanner inputStream = new Scanner(new File(absoluteFilepath));
            while (inputStream.hasNextLine()) {
                content = content + inputStream.nextLine();
            }
        } catch (FileNotFoundException fe) {}

        return content;
    }
    
    /**
     * TRANSFER String into usable datastructure.
     * @param jsonString
     * @return ArrayList<Question>
     */
    public static ArrayList<Question> getQuestionsFromJsonString(String jsonString) {
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

    /**
     *  TRANSFER datastructure into Json formatted String.
     * @param questions
     * @return
     */
    public static String getJsonStringFromQuestions(ArrayList<Question> questions) {
        JsonObject quizJsonObject = new JsonObject();
        JsonArray allQuestions = new JsonArray();

        for (Question question: questions) {
            JsonObject questionJsonObj = new JsonObject();
            questionJsonObj.add(ConstantTable.QUESTION_TITLE, new JsonPrimitive(question.getTitle()));
            JsonArray optionsArray = new JsonArray();
            for (String optionStatement: question.getOptions()) {
                optionsArray.add(new JsonPrimitive(optionStatement));
            }
            questionJsonObj.add(ConstantTable.QUESTION_OPTIONS, optionsArray);
            questionJsonObj.add(ConstantTable.QUESTION_CORRECT_ANSWER, new JsonPrimitive(question.getCorrectAnswer()));
            allQuestions.add(questionJsonObj);
        }

        quizJsonObject.add(ConstantTable.QUIZ_IDENTIFIER, allQuestions);

        Gson jsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = jsonBuilder.toJson(quizJsonObject);
        return jsonString;
    }

    /**
     * SAVE string to file.
     * @param absoluteFilepath
     * @param content
     */
    public static void writeStringToFile(String absoluteFilepath, String content) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(absoluteFilepath);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {}
    }
}
