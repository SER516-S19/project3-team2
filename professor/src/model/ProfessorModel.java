/**
 * 
 * @author leharbhatt
 *
 */
package src.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.ConstantTable;
import src.JsonUtils;
import src.Question;

public class ProfessorModel {

	public String createQuiz(ArrayList<Question> questionList, String absolutePath) {
		if (questionList != null && questionList.size() > 0) {
			String questionListString = JsonUtils.getJsonStringFromQuestions(questionList);
			JsonUtils.writeStringToFile(absolutePath, questionListString);
			return ConstantTable.CREATED;
		}
		return ConstantTable.BLANK;
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

	public String deleteQuestion(List<Question> questionList, String questionTitle) {
		if(questionTitle.isEmpty())
			return ConstantTable.BLANK;
		if (questionList != null && questionList.size() > 0) {
			Iterator<Question> iter = questionList.iterator();
			boolean deleteElementFound = false;
			while (iter.hasNext()) {
				Question question = iter.next();
				if (question.getTitle().equalsIgnoreCase(questionTitle)) {
					iter.remove();
					deleteElementFound = true;
					break;
				}
			}
			if (!deleteElementFound) {
				return ConstantTable.NOT_FOUND;
			}

		} else {
			return ConstantTable.EMPTY;
		}
		return ConstantTable.DELETED;
	}
}