/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import View.BookRegistrationView;

/**
 *
 * @author hylan
 */
public class BookRegistrationHelper {

    private final BookRegistrationView bookregistrationview;

    public BookRegistrationHelper(BookRegistrationView bookregistrationview) {
        this.bookregistrationview = bookregistrationview;
    }

    public BookRegistrationHelper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAuthor() {
        return bookregistrationview.gettxtBookAuthor().getText();
    }

    public String getGenre() {
        return bookregistrationview.gettxtBookGenre().getText();
    }

    public String getName() {
        return bookregistrationview.gettxtBookName().getText();
    }

    public String getPublisher() {
        return bookregistrationview.gettxtBookPublisher().getText();
    }

}
