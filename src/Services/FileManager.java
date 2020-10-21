/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class FileManager {
    
    public static final String pcUser = System.getProperty("user.");
    public static final String defaultFolderWay = System.getProperty("user.home") + "/Documents/Oasis";
    
    public void createFolder(String name){
     
        File folder = new File (defaultFolderWay +"/"+name); 
        
        if(folder.exists()){
            Dialoger.message(null, "A pasta: "+name+" Já existe. \n\n Caminho: "+folder.getAbsolutePath());
        }else{
            if(folder.mkdirs()){
            Dialoger.message(null, "A pasta: "+name+" foi criado com sucesso. \n\n Caminho: "+folder.getAbsolutePath());
            }else{
                 Dialoger.message(null, "A pasta: "+name+" nao pode ser criado. \n\n Caminho: "+folder.getAbsolutePath());
             }
        }
    }
    
    public void createFolder(File folder){
        
        if(folder.exists()){
            Dialoger.message(null, "A pasta: "+folder.getName()+" Já existe. \n\n Caminho: "+folder.getAbsolutePath());
        }else{
            folder.mkdir();
            Dialoger.message(null, "A pasta: "+folder.getName()+" foi criado com sucesso. \n\n Caminho: "+folder.getAbsolutePath());
        }
    }
    
    public void copyFileTo(File file,File destiny){
        
        if(destiny.exists()){
            Dialoger.message(null, "O arquivo: "+destiny.getName()+" Já existe. \n\n Caminho: "+destiny.getAbsolutePath());
        }else{

            FileInputStream input = null;
            FileOutputStream output = null;
            
            try {
               
                input = new FileInputStream(file);
                output = new FileOutputStream(destiny);
              
                FileChannel fcOrigin = input.getChannel();
                FileChannel fcDestiny = output.getChannel();
               
                fcOrigin.transferTo(0, fcOrigin.size(), fcDestiny);
                
                Dialoger.message(null, "O arquivo: "+destiny.getName()+" foi copiado com sucesso. \n\n Caminho: "+destiny.getAbsolutePath());
           
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
           
            } finally {
                
                try {
                    input.close();
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
