/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class Student extends Manager implements Model.Interface.User{
    
    private BackupImage imagePerfil;
    private String registration;
    private String module;
    private String grade;
    private String course;
    private String shift;
    private ArrayList<Rent> rents;

    public Student(BackupImage imagePerfil, String registration, String module, String grade, String course, String shift, ArrayList<Rent> rents) {
        this.imagePerfil = imagePerfil;
        this.registration = registration;
        this.module = module;
        this.grade = grade;
        this.course = course;
        this.shift = shift;
        this.rents = rents;
        this.accessLevel = User.ACCESS_MIN;
    }
    
    public Student() {
        
        imagePerfil = new BackupImage();
        this.accessLevel = User.ACCESS_MIN;
    }
    
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public ArrayList<Rent> getRents() {
        return rents;
    }

    public void setRents(ArrayList<Rent> rents) {
        this.rents = rents;
    }
    
}
