/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.BookFactory;
import JDBC.ConnectionFactory;
import Model.Book;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Samuel
 */
public class BookDAO {
    
     private Connection connection;
    private String sql;
    private static Book selectedBook;

    public boolean insert(Book book){
        
        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_book (book_name, book_author, book_publisher, book_stock, book_genre, book_acquired_date, book_image_name) VALUES (?,?,?,?,?,?,?);";

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setInt(4, book.getStock());
            statement.setString(5, book.getGenre());
            statement.setDate(6, book.getAcquired().toSQLDate());
            statement.setString(7, book.getImage().getImageFile().getFile().getName());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
        
    }
    
    public boolean update(Book book){
        
    connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_book SET book_name = ?, book_author = ?, book_publisher = ?, book_stock = ?, book_genre = ?, book_acquired_date = ?, book_image_name = ? WHERE id_book = ?;";
        
           
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setInt(4, book.getStock());
            statement.setString(5, book.getGenre());
            statement.setDate(6, book.getAcquired().toSQLDate());
            statement.setString(7, book.getImage().getImageFile().getFile().getName());
            statement.setInt(8, book.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
    }

    
    public boolean delet(Book book){
            
    connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_book WHERE id_book = ?;";
        

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, book.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
    }
    

    public List<Book> selectAll(){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_book;";
        List<Book> books = new ArrayList<>();
   
          try {
              
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                Book book = BookFactory.generateBook(result);

                books.add(book);
            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return books;
    }
    
    public List<Book> search(String method, String search){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_book WHERE book_"+method+" LIKE ?;";
        List<Book> books = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
              Book book = BookFactory.generateBook(result);

                
                books.add(book);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return books;
    }
    
    public boolean exist(String search){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_book WHERE book_name LIKE ?;";
            boolean exist = false;
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            
            result = statement.executeQuery();
            
            exist = result.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }
    
    private void connect() {
     
        connection = ConnectionFactory.getConnection();

    }

    public List<Book> fastSearch(String search) {
   
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_book WHERE book_name LIKE ? OR book_genre LIKE ?;";
        List<Book> books = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            statement.setString(2, "%"+search+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
              Book book = BookFactory.generateBook(result);

                
                books.add(book);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return books;
    }
    
    public List<Book> deepSearch(String search) {
   
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_book WHERE book_name LIKE ? OR book_genre LIKE ? OR book_author LIKE ? OR book_publisher LIKE ?;";//OR book_stock LIKE ?;";
        List<Book> books = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            statement.setString(2, "%"+search+"%");
            statement.setString(3, "%"+search+"%");
            statement.setString(4, "%"+search+"%");
           // statement.setInt(5, Integer.parseInt(search));
            
            result = statement.executeQuery();
            
            while(result.next()){
                
              Book book = BookFactory.generateBook(result);

                
                books.add(book);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return books;
    }
}
