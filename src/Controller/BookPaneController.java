/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import Model.ImageFile;
import View.Components.BookPane;
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
//            resizeImageLabe(view.getjLabelImage());
//            setImage();
    }

    public void setImage() {
        
        
        ImageFile.resizeImageByPath(view.getjLabelImage(), Book.DefaultBookImage().getFile().getAbsolutePath());
    }

    private void resizeImageLabe(JLabel label) {
    
        label.setSize(172, 160);
    }
    
}
