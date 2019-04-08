package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utils.*;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author leharbhatt
 *
 */

public class ProfessorController implements ActionListener {

	String classpath = ProfessorController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	final String JSONEXTENSION = ".json";
	private List<Question> questions = new ArrayList<Question>();
	private String quizName;

	public ProfessorController(List<Question> questions, String quizName) {
		this.questions.addAll(questions);
		this.quizName = quizName;
	}

	public ProfessorController() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print(classpath);
		try {
			List<Question> questionsList = new ArrayList<Question>();
			List<String> options1 = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
			Question q1 = new Question("Question1", options1, "Option 1");
			List<String> options2 = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
			Question q2 = new Question("Question2", options2, "Option 4");

			questionsList.add(q1);
			questionsList.add(q2);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter()
					.writeValue(new File(classpath + File.separator + quizName + JSONEXTENSION), questionsList);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * This is a test method. Delete after the UI integration is complete
	 */
	public void testMethod() {
		// File oneMoreDirectory = new File(classpath + File.separator + "file1.json");
		List<Question> questionsList = new ArrayList<Question>();
		List<String> options1 = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
		Question q1 = new Question("Question1", options1, "Option 1");
		List<String> options2 = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
		Question q2 = new Question("Question2", options2, "Option 4");

		questionsList.add(q1);
		questionsList.add(q2);
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Writing to a file
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(classpath + File.separator + "quiz2.json"),
					questionsList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		ProfessorController con = new ProfessorController();
		con.testMethod();
	}
}
