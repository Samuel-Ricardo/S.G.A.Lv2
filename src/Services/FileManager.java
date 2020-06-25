/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import View.Dialoguer;
import java.io.File;

/**
 *
 * @author Samuel
 */
public class FileManager {
    
    public static final String pcUser = System.getProperty("user.");
    public static final String defaultFolderWay = System.getProperty("user.documents") + "/Oasis";
    
    public void createFolder(String name){
     
        File folder = new File (defaultFolderWay +"/"+name); 
        
        if(folder.exists()){
            Dialoguer.message(null, "A pasta: "+name+" Já existe. \n\n Caminho: "+folder.getAbsolutePath());
        }else{
            folder.mkdir();
            Dialoguer.message(null, "A pasta: "+name+" foi criado com sucesso. \n\n Caminho: "+folder.getAbsolutePath());
        }
    }
    
    public void createFolder(File folder){
        
        if(folder.exists()){
            Dialoguer.message(null, "A pasta: "+folder.getName()+" Já existe. \n\n Caminho: "+folder.getAbsolutePath());
        }else{
            folder.mkdir();
            Dialoguer.message(null, "A pasta: "+folder.getName()+" foi criado com sucesso. \n\n Caminho: "+folder.getAbsolutePath());
        }
    }
    
}
