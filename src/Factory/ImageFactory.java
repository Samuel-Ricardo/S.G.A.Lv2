/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.ImageFile;
import Services.FileManager;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class ImageFactory {
    
    private static ImageFile image = null;
    
    public static ImageFile generateImage(ResultSet result) throws SQLException {
        
        String imageName = result.getString("image_name");
        
        ImageFile image;
        
        if(ImageFile.exist(imageName) == false){
            
            image = new ImageFile(result.getBinaryStream("image_bytes"), imageName);
            
        }else{
            
            image = new ImageFile(FileManager.defaultFolderWay+"/Images/"+imageName);
        }
        
        
        
        return image;
    }
    
    public static ArrayList<ImageFile> generateImages(ResultSet result) throws SQLException {
        
        ArrayList<ImageFile> images = new ArrayList<>();

        while(result.next()){
            
            String imageName = result.getString("image_name");

            if(ImageFile.exist(imageName) == false){

                image = new ImageFile(result.getBinaryStream("image_bytes"), imageName);

                images.add(image);
            }
        }
        
        return images;
    }
    
}
