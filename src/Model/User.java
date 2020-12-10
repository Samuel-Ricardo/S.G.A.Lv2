/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ImageDAO;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class User implements Model.Interface.User{
    
    protected Long id;
    protected String name;
    protected String login;
    protected String password;
    protected BackupImage perfilImage;
    protected String email;
    protected String address;
    protected String CEP;
    protected String phone;
    protected int accessLevel;

    public User(Long id, String name, String login, String password, BackupImage perfilImage, String email, String address, String CEP, String phone) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.perfilImage = perfilImage;
        this.email = email;
        this.address = address;
        this.CEP = CEP;
        this.phone = phone;
    }

    public User(String name, String login, String password, BackupImage perfilImage, String email, String address, String CEP, String phone) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.perfilImage = perfilImage;
        this.email = email;
        this.address = address;
        this.CEP = CEP;
        this.phone = phone;
    }

    public User() {
       perfilImage = new BackupImage();
    }
    
    @Override
    public int getAccessLevel() {
        return accessLevel;
    }

     @Override
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
    
     @Override
    public Long getId() {
        return id;
    }

     @Override
    public void setId(Long id) {
        this.id = id;
    }
    
     @Override
    public void setId(int id) {
        this.id = new Long(id);
    }

     @Override
    public String getName() {
        return name;
    }

     @Override
    public void setName(String name) {
        this.name = name;
    }

     @Override
    public String getLogin() {
        return login;
    }

     @Override
    public void setLogin(String login) {
        this.login = login;
    }

     @Override
    public String getPassword() {
        return password;
    }

     @Override
    public void setPassword(String password) {
        this.password = password;
    }

     @Override
    public BackupImage getPerfilImage() {
        return perfilImage;
    }

     @Override
    public void setPerfilImage(BackupImage perfilImage) {
        this.perfilImage = perfilImage;
    }
    
     @Override
    public void setPerfilImage(ImageFile perfilImage) {
        
        ImageDAO imageDao = new ImageDAO();
        
        List<BackupImage> images = imageDao.searchByName(perfilImage.getFile().getName());
        
        if(images.isEmpty() == false){
            
            this.perfilImage = images.get(0);
        }else{
            this.perfilImage.setImageFile(perfilImage);
        }
    }
        
     @Override
    public String getEmail() {
        return email;
    }

     @Override
    public void setEmail(String email) {
        this.email = email;
    }

     @Override
    public String getAddress() {
        return address;
    }

     @Override
    public void setAddress(String address) {
        this.address = address;
    }

     @Override
    public String getCEP() {
        return CEP;
    }

     @Override
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

     @Override
    public String getPhone() {
        return phone;
    }

     @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
