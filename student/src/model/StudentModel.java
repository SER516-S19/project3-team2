package student.model;

import utils.*;
import java.util.ArrayList;
import java.io.*;

/**
 * Student model to read the .json file and create question list
 * 
 * @author Subhradeep
 * @version 1.1
 * @date 04/09/2019
 */

public class StudentModel {
	private ArrayList<Question> questionList;
	private static String folderPath = System.getProperty("user.home") + "/quiz/";

	public ArrayList<Question> getQuestionList(String str) {
		String jsonStrAllQst = JsonUtils.getStringFromFile(folderPath + str + ".json");
		this.questionList = new ArrayList<Question>(JsonUtils.getQuestionsFromJsonString(jsonStrAllQst));
		return this.questionList;
	}

	public String[] getQuizNames() {
		String[] quizNames = new String[100];
		String currFileName;
		int dotIndex;
		String folderPath = System.getProperty("user.home") + "/quiz/";
		File folder = new File(folderPath);
		if (folder.exists()) {
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					currFileName = listOfFiles[i].getName();
					dotIndex = currFileName.indexOf(".");
					quizNames[i] = currFileName.substring(0, dotIndex);
				} else if (listOfFiles[i].isDirectory()) {
					System.out.println(listOfFiles[i].getName() + " is not a file.");
				}
			}
		}
		return quizNames;
	}
}
