/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Components;

import Model.Book;
import View.Components.BookList;
import View.Components.BookPane;
import java.util.List;
import javax.swing.Box;

/**
 *
 * @author Samuel
 */
public class BookListController {
    
    private final BookList view;
    private final Box layout;
    private final List<Book> books;

    public BookListController(BookList view, Box layout,List<Book> books) {
        this.view = view;
        this.layout = layout;
        this.books = books;
        
        start();
    }
    
    public void start(){
     
        loadBooks(books);
    }

    public void loadBooks(List<Book> books) {
      
         for (Book book : books) {
            
            BookPane pane = new BookPane(book, null);

            pane.getInsets().set(10, 10, 10, 10);

            layout.add(pane);
         }
         
        view.getjPanelBookList().add(layout);
        
        view.updateUI();
    }
    
}
