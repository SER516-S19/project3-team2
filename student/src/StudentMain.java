package src;

import src.*;
import src.view.*;
import src.model.*;
import src.controller.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    StudentMainWindow mainWindow = new StudentMainWindow();
                    mainWindow.setVisible(true);
                    TakeQuizView theView = new TakeQuizView();
                    StudentModel theModel = new StudentModel();
            		CompletionMessage theMessage = new CompletionMessage();
                    StudentController theController = new StudentController(theModel, mainWindow, theView, theMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
