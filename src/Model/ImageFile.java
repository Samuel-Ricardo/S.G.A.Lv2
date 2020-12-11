/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Services.FileManager;
import View.Login;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Samuel
 */
public class ImageFile {
    
    private byte[] bytes;
    private File file;
    private int length ;
    private int lengthKB = length / 1024;
    private int lengthMB = lengthKB / 1024;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private ImageIcon imageSwing;
    private Image ImageFX;

    public ImageFile(String absolutePath) {
       
        this.file = new File(absolutePath);

        start();
    }

    public ImageFile(String string, String string1) {
        this.file = new File(string, string1);

        start();
    }

    public ImageFile(File file, String string) {
        this.file = new File(file,string);

        start();
    }

    public ImageFile(URI uri) {
        this.file = new File(uri);

        start();
    }    

    public ImageFile(File file) {
        this.file = file;
    }
    
   public ImageFile(InputStream inputS, String name) {
        
        try {
            this.bytes = new byte[1024];
            
            String PCuser = System.getProperty("user.name");
            
            file = new File(FileManager.getDefaultFolder()+"\\Images\\"+name);
            
            System.out.println("arqucivo:                   "+file.getAbsolutePath());
            
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(file);
            
                System.out.println("Começou o download");
                
                while(inputS.read(bytes) != -1){
                    
                    outputStream.write(bytes);
                    
                }
                
            outputStream.close();
            inputS.close();
            
            start();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImageFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImageFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

    private void start() {
 //       try {
            JFXPanel jfxPanel = new JFXPanel();
            
            this.length = (int) file.length();

            this.bytes = new byte[length];

            this.imageSwing = new ImageIcon(file.getAbsolutePath());
            this.ImageFX = new Image("file:///"+file.getAbsolutePath());
    }
    
    
    public static boolean exist(String imageName) {
        
       String PCuser = System.getProperty("user.name");
       
       File search = new File("C:\\Users\\"+PCuser+"\\Documents\\SAGAL\\images\\"+imageName);
       
       return search.exists();
    }
    
    public boolean existByWay(String way) {
       
       File search = new File(way);
       
       return search.exists();
    }
    
    public static void resizeImage(JLabel jLabel, String way) {
        
        ImageIcon img = new ImageIcon(Login.class.getResource(way));
        
        jLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), java.awt.Image.SCALE_DEFAULT)));
    }
    
    public static void resizeImageByPath(JLabel jLabel, String way) {
        
        ImageIcon img = new ImageIcon(way);
        
        jLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), java.awt.Image.SCALE_DEFAULT)));
    }
    
    public void resizeImage(JLabel jLabel) {
        
        jLabel.setIcon(new ImageIcon(imageSwing.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), java.awt.Image.SCALE_DEFAULT)));
    }
    
    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLengthKB() {
        return lengthKB;
    }

    public void setLengthKB(int lengthKB) {
        this.lengthKB = lengthKB;
    }

    public int getLengthMB() {
        return lengthMB;
    }

    public void setLengthMB(int lengthMB) {
        this.lengthMB = lengthMB;
    }

    public FileInputStream getInputStream() {
        try {
            
            if(this.file.exists()){
               return new FileInputStream(this.file);
            }else{
                return null;
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void setInputStream(FileInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public FileOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(FileOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public ImageIcon getImageSwing() {
        return imageSwing;
    }

    public void setImageSwing(ImageIcon imageSwing) {
        this.imageSwing = imageSwing;
    }

    public Image getImageFX() {
        return ImageFX;
    }

    public void setImageFX(Image ImageFX) {
        this.ImageFX = ImageFX;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    

}
