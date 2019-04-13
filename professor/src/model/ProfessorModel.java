/**
 * 
 * @author leharbhatt
 *
 */
package src.model;

import java.util.Iterator;

import src.ConstantTable;
import src.Question;

public class ProfessorModel {
	public void createQuiz() {

	}

	public String addQuestion(Question question) {
		boolean correctAnsMatched = false;
		if (question.getTitle().isEmpty()) {
			return ConstantTable.BLANK;
		} else if (question.getCorrectAnswer().isEmpty()) {
			return ConstantTable.BLANK;
		}
		for (String option : question.getOptions()) {
			if (option.isEmpty()) {
				return ConstantTable.BLANK;
			}
		}
		for (String option : question.getOptions()) {
			if (question.getCorrectAnswer().equalsIgnoreCase(option)) {
				correctAnsMatched = true;
			}
		}
		if (!correctAnsMatched)
			return ConstantTable.NOT_FOUND;

		return ConstantTable.ADDED;
	}

	public void deleteQuestion() {
//		boolean deleteElementFound = false;
//		addView.fetchQuestionDetails();
//		if (questionList != null && questionList.size()>0) {
//			Iterator<Question> iter = questionList.iterator();
//
//			while (iter.hasNext()) {
//				Question question = iter.next();
//				if (question.getTitle().equalsIgnoreCase(addView.getQuesTitle())) {
//					iter.remove();
//					deleteElementFound = true;
//				}
//			}
	}
}