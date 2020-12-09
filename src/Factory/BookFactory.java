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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class BookFactory {
    
    private FileManager fileManager = new FileManager();
    
    public static Book generateBook(ResultSet result) throws SQLException {
        
        Book book = new Book();
        ImageFactory imageFactory = new ImageFactory();
        
       // List<BackupImage> listImage = imageDAO.searchByName("book_image_name");
        
        book.setId(result.getInt("id_book"));
        book.setName(result.getString("book_name"));
        book.setAuthor(result.getString("book_author"));
        book.setPublisher(result.getString("book_publisher"));
        book.setStock(result.getInt("book_stock"));
        book.setGenre(result.getString("book_genre"));
        book.setAcquired(result.getDate("book_acquired_date"));
        
        if(result.getString("book_image_name") != null){
            
            fileManager.getFileInDefaultFolder("")
            
            book.setImage(imageFactory.generateBackupImage(result));
        }
        
      //  if(listImage.isEmpty() == false){
            
      //       book.setImage(imageDAO.searchByName("book_image_name").get(0));
      //  }else{
      //      book.setImage(new BackupImage());
      //  }
        
        return book;
    }
    
}
