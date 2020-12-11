/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Components;

import Model.Student;
import Model.ImageFile;
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
             
                ListOfStudents.setSelectedStudentPane(view);
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
            view.getjLabelCourse().setText(student.getCourse());
            view.getjLabelGrade().setText(student.getGrade());
            resizeImageLabe(view.getjLabelImage());
            setImage();
            
            view.setMaximumSize(new Dimension(196, 270));
            System.out.println("paod                   equeio");
            
            selectListener();
    }

    public void setImage() {
        
        if(student.getPerfilImage() != null){
            if(student.getPerfilImage().getImageFile().getFile().exists()){
                System.out.println("estudante criado id: "+student.getId()+" caminho da imagen: "+ student.getPerfilImage().getImageFile().getFile().getAbsolutePath());
                ImageFile.resizeImageByPath(view.getjLabelImage(), student.getPerfilImage().getImageFile().getFile().getAbsolutePath());
            }else{
                setEmptyImage();
            }
        }else{
            setEmptyImage();
        }
        
    }

    public void setEmptyImage() {
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

    public MouseListener getMouseSelectListener() {
        return MouseSelectListener;
    }

    public void setMouseSelectListener(MouseListener MouseSelectListener) {
        this.MouseSelectListener = MouseSelectListener;
    }

    public ListOfStudents getFather() {
        return father;
    }
}
