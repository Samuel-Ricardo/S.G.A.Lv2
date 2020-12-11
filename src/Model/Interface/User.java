/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import Model.BackupImage;
import Model.ImageFile;

/**
 *
 * @author Samuel
 */
public interface User {
    
    public static final int ACCESS_MAX = 3;
    public static final int ACCESS_MED = 2;
    public static final int ACCESS_MIN = 1;
    
    public int getAccessLevel();
    public void setAccessLevel(int accessLevel);
    
    public Long getId();
    public void setId(Long id);
    public void setId(int id);
    
    public String getName();
    public void setName(String name);
    
    public String getLogin();
    public void setLogin(String login);
    
    public String getPassword();
    public void setPassword(String password);
    
    public BackupImage getPerfilImage();
    public void setPerfilImage(BackupImage perfilImage);
    
    public void setPerfilImage(ImageFile perfilImage);
    
    public String getEmail();
    public void setEmail(String email);
    
    public String getAddress();
    public void setAddress(String address);
    
    public String getCEP();
    public void setCEP(String CEP);
    
    public String getPhone();
    public void setPhone(String phone);
}
