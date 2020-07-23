/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Pane;

import Model.Book;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Samuel
 */
public class BookPane extends JPanel{
    
    private JLabel name;
    private JLabel labelImage;
    private JLabel labelStock;
    private JLabel stockQuantity;
    private JLabel labelGenre;
    private JLabel BookGenre;
    private ImageIcon bookImage;
    private Book book;

    public BookPane(JLabel name, JLabel labelImage, JLabel labelStock, JLabel stockQuantity, JLabel labelGenre, JLabel BookGenre, ImageIcon bookImage, Book book) {
        this.name = name;
        this.labelImage = labelImage;
        this.labelStock = labelStock;
        this.stockQuantity = stockQuantity;
        this.labelGenre = labelGenre;
        this.BookGenre = BookGenre;
        this.bookImage = bookImage;
        this.book = book;
        
        load(name, labelGenre, labelImage, labelStock, book, stockQuantity, BookGenre, bookImage);
    }

    public BookPane(Book book) {
        
        this.book = book;
        this.bookImage = new ImageIcon();
        this.BookGenre = new JLabel();
        this.labelGenre = new JLabel();
        this.labelImage = new JLabel();
        this.labelStock = new JLabel();
        this.name = new JLabel();
        this.stockQuantity = new JLabel();
        
        load();
    }

    public void load(JLabel name, JLabel labelGenre, JLabel labelImage, JLabel labelStock, Book book, JLabel stockQuantity, JLabel BookGenre, ImageIcon bookImage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void load() {
       
        this.add(name);
        
       name.setText(book.getName());
        
    }
    
    
    
}
