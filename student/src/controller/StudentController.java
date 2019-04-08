package student.controller;
import utility.utils.*;
import java.util.ArrayList;

public class StudentController {
	public ArrayList<Question> questionList;
	
	public void populateQuiz(String str){
		
		String filePath = "C:/Users/subhr/Desktop/Desktop_Folders/SER516/";
		String jsonStrAllQst =  JsonUtils.getStringFromFile(filePath+str);
		
		this.questionList = new ArrayList<Question>(JsonUtils.getQuestionsFromJsonString(jsonStrAllQst));
		
	}

}
