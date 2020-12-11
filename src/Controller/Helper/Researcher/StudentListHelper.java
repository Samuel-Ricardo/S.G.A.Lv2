/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper.Researcher;

import Model.Student;
import Model.ImageFile;
import Services.FileManager;
import View.Components.StudentPane;
import View.Researchers.ListOfStudents;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;

/**
 *
 * @author Samuel
 */
public class StudentListHelper {

    private final ListOfStudents view;

    public StudentListHelper(ListOfStudents view) {
        this.view = view;
    }

    public void setStudentOnList(ArrayList<Student> students, Box box) {

        for (Student student : students) {
            
            StudentPane pane = new StudentPane(student, view);

            pane.getInsets().set(10, 10, 10, 10);

            box.add(pane);

            System.out.println(pane.getController().getStudent().getAddress()+ "   " + view.getjPanelStudentList().getWidth());
        }
        view.getjPanelStudentList().add(box);
        
        
        view.getjPanelStudentList().updateUI();
    }

    public void loadStudentDetails() {

        Student student = ListOfStudents.getSelectedStudentPane().getStudent();

        view.getjLabelName().setText(student.getName());
        view.getjLabelAddress().setText(student.getAddress());
        view.getjLabelCEP().setText(student.getCEP());
        view.getjLabelCourse().setText(student.getCourse());
        view.getjLabelEmail().setText(student.getEmail());
        view.getjLabelGrade().setText(student.getGrade());
        view.getjLabelLogin().setText(student.getLogin());
        view.getjLabelModule().setText(student.getModule());
        view.getjLabelPassword().setText(student.getPassword());
        view.getjLabelPhone().setText(student.getPhone());
        view.getjLabelRegistration().setText(student.getRegistration());
        view.getjLabelSchool().setText(student.getSchool());
        view.getjLabelShift().setText(student.getShift());
        setStudentImage(student);
        
       // loadStudentImage(student);
    }

    public void setStudentImage(Student student) {
        
        view.getjLabelStudentImage().setText("");
        
        if(student.getPerfilImage() != null){
            if(student.getPerfilImage().getImageFile().getFile().exists()){
                
                ImageFile.resizeImageByPath(view.getjLabelStudentImage(), student.getPerfilImage().getImageFile().getFile().getAbsolutePath());
            }else{
                setEmptyImage();
            }
        }else{
            setEmptyImage();
        }
    }

//    public void loadStudentImage(Student student) {
//
//        view.getjLabelImageStudent().setText("");
//
//        if (student.getImage().isEmpty() == false) {
//
//            view.getjLabelImageStudent().setIcon(student.getImage().get(0).getImageSwing());
//
//            ImageFile.resizeImageByPath(view.getjLabelImageStudent(), student.getImage().get(0).getFile().getAbsolutePath());
//
//        } else {
//
//            ImageFile.resizeImage(view.getjLabelImageStudent(), Student.DEFAULT_IMAGE_WAY);
//        }
//    }

    private void setEmptyImage() {
     ImageFile.resizeImage(view.getjLabelStudentImage(), FileManager.NO_IMAGE);
    }

}
