/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Book;
import Model.Pane.BookPane;
import View.ListOfBooks;

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
        
        BookPane pane = new BookPane(book);
   
        pane.getInsets().set(10, 10, 10, 10);
        
        view.getjPanelBookList().add(pane);
    }
    
}
