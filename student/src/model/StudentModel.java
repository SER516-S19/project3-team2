/* 
Student model to read the .json file and create question list
@author Subhradeep 
@version 1.1
@date 04/09/2019
*/

package student.model;

import utility.utils.*;
import java.util.ArrayList;

public class StudentModel {
	private ArrayList<Question> questionList;
	
	public ArrayList<Question> getQuestionList(String str) {
		String filePath = "C:/Users/subhr/Desktop/Desktop_Folders/SER516/QuizCreation/";
		String jsonStrAllQst =  JsonUtils.getStringFromFile(filePath+str+".json");
		
		this.questionList = new ArrayList<Question>(JsonUtils.getQuestionsFromJsonString(jsonStrAllQst));
		return this.questionList;
	}
}
