/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Registers;

import Controller.Helper.Register.BookRegistrationHelper;
import DAO.BookDAO;
import DAO.ImageDAO;
import Factory.BookFactory;
import Model.Book;
import Model.ImageFile;
import Time.Time;
import View.Registers.BookRegistrationView;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hylan
 */
public class BookRegistrationController {

    private final BookRegistrationView view;
    private final BookDAO bookDao;
    private final BookRegistrationHelper helper;
    private ImageFile image = new ImageFile("");
    
    public BookRegistrationController(BookRegistrationView view) {
        this.view = view;
        this.bookDao = new BookDAO();
        this.helper = new BookRegistrationHelper(view);
    }
    
    public void newBook(){
        
        try {
            
            String Author = helper.getAuthor();
            String Genre = helper.getGenre();
            String Name = helper.getName();
            int stock = helper.getStock();
            String Publisher = helper.getPublisher();
            
            Book book = new Book();
            
            Time acquired = helper.getAcquiredDate();
            
            System.out.println("deate         "+acquired.getOnlyDate());
            
            book.setAcquired(acquired);
            book.setAuthor(Author);
            book.setGenre(Genre);
            book.setName(Name);
            book.setPublisher(Publisher);
            book.setStock(stock);
            book.setImage(image);
            
            BookFactory.saveImageOnBook(image.getFile().getName(), book, new ImageDAO());
            
            if (bookDao.insert(book)){
                
                JOptionPane.showMessageDialog(view, "O livro: "+book.getName()+", foi salvo com sucesso :)");
                
            }else{
                JOptionPane.showMessageDialog(view, "Erro ao salvar o livro: "+book.getName());
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao salvar o livro :(");
            
            ex.printStackTrace();
        }
    }

    public void resize(JLabel jLabelImage) {

        ImageFile.resizeImage(jLabelImage, "/View/Images/icons8-no-image-64px.png");
    }

    public void start() {
        
        Date date = new Date();
        
        String string = Time.getDateFormat().format(date);
        
      view.getjFormattedTextFieldAcquisition().setText(string);
    }

    public void chooseImage() {
        
        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION){
            
            File file = chooser.getSelectedFile();
            image = new ImageFile(file);
            
            ImageFile.resizeImageByPath(view.getjLabelImageBook(), file.getAbsolutePath());
        }
        
    }
}
