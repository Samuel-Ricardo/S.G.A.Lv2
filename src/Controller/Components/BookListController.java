/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Components;

import Model.Book;
import View.Components.BookList;
import javax.swing.Box;

/**
 *
 * @author Samuel
 */
public class BookListController {
    
    private final BookList view;
    private final Box layout;

    public BookListController(BookList view, Box layout,List<Book> books) {
        this.view = view;
        this.layout = layout;
        
        start();
    }
    
    public void start(){
     
        
    }
    
}
