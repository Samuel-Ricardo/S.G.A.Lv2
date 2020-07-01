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

    private final BookRegistrationView view;

    public BookRegistrationHelper(BookRegistrationView view) {
        this.view = view;
    }

    public String getAuthor() {
        return view.gettxtBookAuthor().getText();
    }

    public String getGenre() {
        return view.gettxtBookGenre().getText();
    }

    public String getName() {
        return view.gettxtBookName().getText();
    }

    public String getPublisher() {
        return view.gettxtBookPublisher().getText();
    }

}
