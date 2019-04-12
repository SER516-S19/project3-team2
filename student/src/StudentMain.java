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
                    mainWindow.getContentPane().setBackground(new Color(255, 255, 204));
                    TakeQuizView theView = new TakeQuizView();
                    StudentModel theModel = new StudentModel();
                    StudentController theController = new StudentController(theModel, mainWindow, theView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}