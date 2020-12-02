/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class Downloader extends Thread{
    
    private Dialoger dialoger;
    private boolean downloading = false;

    public Downloader() {
        
        dialoger = new Dialoger();
    }

    public Downloader(Dialoger dialoger) {
        this.dialoger = dialoger;
    }
    
    public void run(){
        
    }
    
    public boolean download(InputStream input, File destiny){
        
        try {
        
            downloading = true;
            
            OutputStream output = new FileOutputStream(destiny);
      
            int bit = 0;
            
            while((bit = input.read()) > -1){
                
                output.write(bit);
            }
        
            input.close();
            output.close();
            
            downloading = false;
            return true;
                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
}
