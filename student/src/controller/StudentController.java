/** 
Student controller to get questions from studentModel 
and populate TakeQuiz window.
@author Subhradeep/Manikanta
@version 1.1
@date 04/09/2019
*/

package src.controller;

import src.model.StudentModel;
import src.view.StudentMainWindow;
import src.view.TakeQuiz;
import utils.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {
	
	private StudentModel studentModel;
	private StudentMainWindow studentMainWin;
	private TakeQuiz takeQuiz;
	private ArrayList<Question> questionList;
	
	public StudentController(StudentModel theModel, StudentMainWindow mainWinView, TakeQuiz takeQuizView) {
		this.studentModel = theModel;
		this.studentMainWin = mainWinView;
		this.takeQuiz = takeQuizView;
		
		mainWinView.setQuizNames(theModel.getQuizNames());
		String[] quizChoices = mainWinView.getQuizChoices();
		mainWinView.setQuizField(quizChoices);
		this.studentMainWin.selectQuizListener(new OkListener());
		this.takeQuiz.nextQuestionListener(new NextListener());
	}
	
	class OkListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String quizName;
            try{
            	quizName = studentMainWin.getQuizName();		                
            	questionList = studentModel.getQuestionList(quizName);
            	takeQuiz.setQuizLabel(studentMainWin.getQuizName());
            	takeQuiz.setQuestionField(questionList.get(0).getTitle());
            	takeQuiz.setRadioOption1(questionList.get(0).getOptions().get(0));
            	takeQuiz.setRadioOption2(questionList.get(0).getOptions().get(1));
            	takeQuiz.setRadioOption3(questionList.get(0).getOptions().get(2));
            	takeQuiz.setRadioOption4(questionList.get(0).getOptions().get(3));
            	takeQuiz.setVisible(true);
            }
            catch(NumberFormatException ex){
                System.out.println(ex);
                studentMainWin.displayErrorMessage("The quiz cannot be opened");
            }
        }
    }
	
	class NextListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //String questionText;
            try{
            	questionList.remove(0);
            	
            	if (!questionList.isEmpty()) {
	            	takeQuiz.setQuizLabel(studentMainWin.getQuizName());
	            	takeQuiz.setQuestionField(questionList.get(0).getTitle());
	            	takeQuiz.setRadioOption1(questionList.get(0).getOptions().get(0));
	            	takeQuiz.setRadioOption2(questionList.get(0).getOptions().get(1));
	            	takeQuiz.setRadioOption3(questionList.get(0).getOptions().get(2));
	            	takeQuiz.setRadioOption4(questionList.get(0).getOptions().get(3));
            	}
            	else {
            		takeQuiz.displayCompletionMessage("You have successfully completed the quiz","Congrats!!");
            	}
            }
            catch(NumberFormatException ex){
                System.out.println(ex);
                takeQuiz.displayErrorMessage("The quiz cannot be opened");
            }
        }
    }
}
