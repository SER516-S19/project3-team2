/** 
Student model to read the .json file and create question list
@author Subhradeep 
@version 1.1
@date 04/09/2019
*/

package student.model;

import utils.*;
import java.util.ArrayList;
import java.io.*;

public class StudentModel {
	private ArrayList<Question> questionList;
	
	public ArrayList<Question> getQuestionList(String str) {
		String filePath = "C:/masters/json/";
		String jsonStrAllQst =  JsonUtils.getStringFromFile(filePath+str+".json");
		
		this.questionList = new ArrayList<Question>(JsonUtils.getQuestionsFromJsonString(jsonStrAllQst));
		return this.questionList;
	}
	
	public String[] getQuizNames() {
		String[] quizNames = new String[100];
		String currFileName;
		int dotIndex;
		
		File folder = new File("C:/masters/json/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  currFileName = listOfFiles[i].getName();
			  dotIndex = currFileName.indexOf(".");
			  quizNames[i] = currFileName.substring(0, dotIndex);
		  } else if (listOfFiles[i].isDirectory()) {
			  System.out.println(listOfFiles[i].getName()+" is not a file.");
		  }
		}
		return quizNames;
	}
}
