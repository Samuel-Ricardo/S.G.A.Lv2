/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.ImageFile;
import Model.Student;
import View.Registers.ClientRegister;

/**
 *
 * @author Samuel
 */
public class ClientRegisterHelper {
    
    private final ClientRegister view;

    public ClientRegisterHelper(ClientRegister view) {
        this.view = view;
    }

    public Student getStudent() {
    
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
      
        return view.getCB().getModel().getSelectedItem().toString();
    }

    private String getLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ImageFile getPerfilImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getPhone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getRegistration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getSchool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getShift() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
