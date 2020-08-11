/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import Model.ImageFile;
import View.Components.BookPane;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Samuel
 */
public class BookPaneController {
    
    private final BookPane view;
    private final Book book;

    public BookPaneController(BookPane view, Book book) {
     
        this.view = view;
        this.book = book;
    }

    public void start() {
     
            view.getjLabelName().setText(book.getName());
            view.getjLabelStock().setText(book.getStock().toString());
            view.getjLabelGenre().setText(book.getGenre());
            resizeImageLabe(view.getjLabelImage());
            setImage();
            
            view.setMaximumSize(new Dimension(196, 270));
            System.out.println("paod                   equeio");
            
            selectListener();
    }

    public void setImage() {
        
        ImageFile.resizeImage(view.getjLabelImage(), "/View/Images/icons8-no-image-64px.png");
    }

    private void resizeImageLabe(JLabel label) {
    
        label.setSize(172, 160);
    }

    public BookPane getView() {
        return view;
    }

    public Book getBook() {
        return book;
    }

    private void selectListener() {
    
        view.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
             
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}
