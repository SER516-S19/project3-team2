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
            	for(int i = 0; i < 4; i++) {
            		takeQuiz.setRadioOption(questionList.get(0).getOptions().get(i), i);
            	}
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
            	
               	String ans = "";
                for(int i = 0; i < 4; i++) {
                	if(takeQuiz.getSelected(i)) {
                		ans = takeQuiz.getRadioOption(i);
                		break;
                	}
                }
            	checkQuiz(ans, questionList.get(0).getCorrectAnswer());  	
            	if (!questionList.isEmpty()) {
	            	takeQuiz.setQuizLabel(studentMainWin.getQuizName());
	            	takeQuiz.setQuestionField(questionList.get(0).getTitle());
	            	for(int i = 0; i < 4; i++) {
	            		takeQuiz.setRadioOption(questionList.get(0).getOptions().get(i), i);
	            	}
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
        
        void checkQuiz(String selectedAnswer, String CorrectAnswer) {
        	System.out.println(selectedAnswer+" "+CorrectAnswer);
        	if(selectedAnswer == "") {
        		Question firstQuestion = questionList.get(0);
        		questionList.add(firstQuestion);
        		
        	}
        	if(selectedAnswer.equals(CorrectAnswer)) {
        		questionList.remove(0);
        		
        	}
        	else {
        		Question firstQuestion = questionList.get(0);
        		questionList.remove(0);
        		questionList.add(firstQuestion);
        	}
        }
        
    }
}
