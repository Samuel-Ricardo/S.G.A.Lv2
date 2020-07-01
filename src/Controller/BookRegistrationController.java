/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.BookRegistrationHelper;
import DAO.BookDAO;
import Model.Book;
import View.BookRegistrationView;

/**
 *
 * @author hylan
 */
public class BookRegistrationController {

    private final View.BookRegistrationView BRV;
    private final BookDAO bookdao;
    private final BookRegistrationHelper bookregistrationhelper;

    public BookRegistrationController() {
        this.BRV = new BookRegistrationView();
        this.bookdao = new BookDAO();
        this.bookregistrationhelper = new BookRegistrationHelper();
    }
    
    public void NewNook(){
     String Author = bookregistrationhelper.getAuthor();
     String Genre = bookregistrationhelper.getGenre();
     String Name = bookregistrationhelper.getName();
     String Publisher = bookregistrationhelper.getPublisher();
        Book book = null;
     
     bookdao.insert(book);
     
     if (book != null){
       
     }
    }
}
