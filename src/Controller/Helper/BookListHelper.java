/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Book;
import View.Components.BookPane;
import View.ListOfBooks;
import javax.swing.Box;
import javax.swing.JLabel;

/**
 *
 * @author Samuel
 */
public class BookListHelper {
    
    private final ListOfBooks view;

    public BookListHelper(ListOfBooks view) {
        this.view = view;
    }

    public void setBookOnList(Book book) {
        
        BookPane pane = new BookPane(book,view);
   
        pane.getInsets().set(10, 10, 10, 10);
        
       // view.getjPanelBookList().add(pane);
        view.getjPanelBookList().add(Box.createHorizontalBox().add(pane));
        
        System.out.println(pane.getController().getBook().getAuthor()+"   "+view.getjPanelBookList().getWidth());
    }
    
}
