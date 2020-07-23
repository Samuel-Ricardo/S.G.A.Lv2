/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.BookListHelper;
import DAO.BookDAO;
import View.ListOfBooks;

/**
 *
 * @author Samuel
 */
public class BookListController {
    
    private final ListOfBooks view;
    private final BookDAO bookDao;
    private final BookListHelper helper;

    public BookListController(ListOfBooks view, BookDAO bookDao, BookListHelper helper) {
        this.view = view;
        this.bookDao = bookDao;
        this.helper = helper;
    }
    
    
    
}
