/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DAO.ImageDAO;
import Model.Book;
import Model.ImageFile;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Samuel
 */
public class BookFactory {
    
    public static Book generateBook(ResultSet result) throws SQLException {
        
        Book book = new Book();
        ImageDAO imageDAO = new ImageDAO();
        
        book.setId(result.getInt("id_book"));
        book.setName(result.getString("book_name"));
        book.setAuthor(result.getString("book_author"));
        book.setPublisher(result.getString("book_publisher"));
        book.setStock(result.getInt("book_stock"));
        book.setGenre(result.getString("book_genre"));
        book.setAcquired(result.getDate("book_acquired_date"));
        book.setImage(imageDAO.searchByName("book_image_name").get(0));
        
        return book;
    }
    
}
