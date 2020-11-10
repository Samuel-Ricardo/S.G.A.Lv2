/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Componens;

import Model.Student;
import Model.ImageFile;
import StudentPane;
import View.Components.StudentPane;
import View.Researchers.ListOfStudents;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Samuel
 */
public class StudentPaneController {
    
    private final StudentPane view;
    private final Student student;
    private final ListOfStudents father;
    private MouseListener MouseSelectListener;

    public StudentPaneController(StudentPane view, Student student, ListOfStudents father) {
     
        this.view = view;
        this.student = student;
        this.father = father;
        
        this.MouseSelectListener = new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
             
                StudentPane(view);
                father.getController().loadDetails();
            }

            @Override
            public void mousePressed(MouseEvent e) {
           
            }

            @Override
            public void mouseReleased(MouseEvent e) {
              
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            
            }

            @Override
            public void mouseExited(MouseEvent e) {
            
            }
        };
    }

    public void start() {
     
            view.getjLabelName().setText(student.getName());
            view.getjLabelStock().setText(student.getStock().toString());
            view.getjLabelGenre().setText(student.getGenre());
            resizeImageLabe(view.getjLabelImage());
            setImage();
            
            view.setMaximumSize(new Dimension(196, 270));
            System.out.println("paod                   equeio");
            
            selectListener();
    }

    public void setImage() {
        
        ImageFile.resizeImage(view.getjLabelImage(), "/View/Images/icons8-no-image-64px.png");
    }

    private void resizeImageLabe(JLabel label) {
    
        label.setSize(172, 160);
    }

    public StudentPane getView() {
        return view;
    }

    public Student getStudent() {
        return student;
    }

    private void selectListener() {
    
        view.addMouseListener(MouseSelectListener);
        
         for(Component comp: view.getComponents()){
             
             comp.addMouseListener(MouseSelectListener);
         }
    }
}
