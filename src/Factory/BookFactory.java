/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DAO.ImageDAO;
import Model.BackupImage;
import Model.Book;
import Model.ImageFile;
import Services.FileManager;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class BookFactory {
    
    
    public static Book generateBook(ResultSet result) throws SQLException {
        
        Book book = new Book();
        ImageFactory imageFactory = new ImageFactory();
        
        book.setId(result.getInt("id_book"));
        book.setName(result.getString("book_name"));
        book.setAuthor(result.getString("book_author"));
        book.setPublisher(result.getString("book_publisher"));
        book.setStock(result.getInt("book_stock"));
        book.setGenre(result.getString("book_genre"));
        book.setAcquired(result.getDate("book_acquired_date"));
        
        if(result.getString("book_image_name") != null){
            
            File file = FileManager.getFileInDefaultFolder("Images/"+result.getString("book_image_name"));
            
            if(file.exists()){
                
                BackupImage backupImage = setLocalImage(file, book);
                
                insertImageIfNotExist(backupImage);
            }else{
                
                book.setImage(imageFactory.generateBackupImageByName(result.getString("book_image_name")));
            }     
        }
        
        return book;
    }

    private static void insertImageIfNotExist(BackupImage backupImage) {
     
        ImageDAO imageDao = new ImageDAO();
        
        if(imageDao.existByName(backupImage) == false){
            
            imageDao.insert(backupImage);
        }
    }

    private static BackupImage setLocalImage(File file, Book book) {
        
        ImageFile imageFile = new ImageFile(file);
        BackupImage backupImage = new BackupImage();
        backupImage.setImageFile(imageFile);
        
        book.setImage(backupImage); 
        
        return backupImage;
    }
    
}
