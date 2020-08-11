/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.BookListHelper;
import DAO.BookDAO;
import Model.Book;
import View.ListOfBooks;
import java.util.ArrayList;
import javax.swing.BoxLayout;

/**
 *
 * @author Samuel
 */
public class BookListController {
    
    private final ListOfBooks view;
    private final BookDAO bookDao;
    private final BookListHelper helper;

    public BookListController(ListOfBooks view) {
        this.view = view;
        this.bookDao = new BookDAO();
        this.helper = new BookListHelper(view);
    }

    public void start() {
    
        view.getjPanelBookList().setLayout(new BoxLayout(view.getjPanelBookList(),BoxLayout.LINE_AXIS));
        
        loadBooks();
    }

    public void loadBooks() {
        
        ArrayList<Book> books = (ArrayList<Book>) bookDao.selectAll();
        
        for (Book book : books) {
            
            helper.setBookOnList(book);
        }
    }

    void loadDetails() {
        
        System.out.println("Detalhes");
    
    }
    

    
}
