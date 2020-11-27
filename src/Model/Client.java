/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ImageFile;
import Model.Manager;
import Model.Rent;
import Model.User;
import java.util.ArrayList;

/**
 *
 * @author hylan
 */
public class Client extends Manager implements Model.Interface.User{
    private ImageFile imagePerfil;
    private String registration;
    private String shift;
    private ArrayList<Rent> rents;

    
    public Client(ImageFile imagePerfil, String registration, String shift, ArrayList<Rent> rents) {
        this.imagePerfil = imagePerfil;
        this.registration = registration;
        this.shift = shift;
        this.rents = rents;
        this.accessLevel = User.ACCESS_MIN;
    }
    public Client() {
        
        imagePerfil = new ImageFile("");
        this.accessLevel = User.ACCESS_MIN;
    }
     public void setImagePerfil(ImageFile imagePerfil) {
        this.imagePerfil = imagePerfil;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setRents(ArrayList<Rent> rents) {
        this.rents = rents;
    }

    public ImageFile getImagePerfil() {
        return imagePerfil;
    }

    public String getRegistration() {
        return registration;
    }

    public String getShift() {
        return shift;
    }

    public ArrayList<Rent> getRents() {
        return rents;
    }
}
