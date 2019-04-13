package src.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.ConstantTable;
import src.JsonUtils;
import src.Question;

/**
 * ProfessorModel performs the action delegated by the ProfessorController.
 * 
 * @author Lehar Bhatt,Aneesh Dalvi
 * @version (1.0)
 * @param (Question)
 */
public class ProfessorModel {

	/*
	 * This method creates a quiz from the list of questions added by the professor.
	 * It creates the file in JSON format and prompts the file location to him.
	 */
	public String createQuiz(ArrayList<Question> questionList, String absolutePath) {
		if (questionList != null && questionList.size() > 0) {
			String questionListString = JsonUtils.getJsonStringFromQuestions(questionList);
			JsonUtils.writeStringToFile(absolutePath, questionListString);
			return ConstantTable.CREATED;
		}
		return ConstantTable.BLANK;
	}

	/*
	 * This method adds the question details in a list of Questions after validating
	 * them.
	 */
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

	/*
	 * This method deletes the question details from the list of Questions after
	 * validating them.
	 */
	public String deleteQuestion(List<Question> questionList, String questionTitle) {
		if (questionTitle.isEmpty())
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