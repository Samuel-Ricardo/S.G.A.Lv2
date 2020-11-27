/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper.Register;

import Model.ImageFile;
import Model.Student;
import View.Registers.StudentRegistrationView;

/**
 *
 * @author Samuel
 */
public class StudentRegisterHelper {
    
    private final StudentRegistrationView view;

    public StudentRegisterHelper(StudentRegistrationView view) {
        this.view = view;
    }

    public Student getStudent() {
    
        //view.getjLabelPerfilImage().updateUI();
        
        Student student = new Student();
        
        student.setAddress(getAddress());
        student.setCEP(getCEP());
        student.setCourse(getCourse());
        student.setEmail(getEmail());
        student.setGrade(getGrade());
        student.setLogin(getLogin());
        student.setModule(getModule());
        student.setName(getName());
        student.setPassword(getPassword());
        student.setPerfilImage(getPerfilImage());
        student.setPhone(getPhone());
        student.setRegistration(getRegistration());
        student.setSchool(getSchool());
        student.setShift(getShift());
        
        return student;
    }

    private String getAddress() {
        
        return view.getTxtAddress().getText();
    }

    private String getCEP() {
       
       return view.getjFormattedTextFieldCEP().getText();
    }

    private String getCourse() {
      
        return view.getCbCourse().getModel().getSelectedItem().toString();
    }

    private String getEmail() {
        
        return view.getTxtEmail().getText();
    }

    private String getGrade() {
        
       return view.getCbGrade().getModel().getSelectedItem().toString();
    }

    private String getModule() {
      
        return view.getCbModule().getModel().getSelectedItem().toString();
    }

    private String getLogin() {
       
        return view.getTxtLogin().getText();
    }

    private String getName() {
    
        return view.getTxtName().getText();
    }

    private String getPassword() {
    
        return new String (view.getjPasswordField().getPassword());
    }

    private ImageFile getPerfilImage() {
    
       return view.getPerfilImage();
    }

    private String getPhone() {
    
        return view.getTxtPhone().getText();
    }

    private String getRegistration() {
      
        return view.getTxtRegistration().getText();
    }

    private String getSchool() {
    
        return view.getTxtSchool().getText();
    }

    private String getShift() {
     
        return view.getCbShift().getModel().getSelectedItem().toString();
    }
}
