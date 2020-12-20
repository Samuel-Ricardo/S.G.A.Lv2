/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rent;

import Controller.Helper.Rent.RentHelper;
import DAO.BookDAO;
import DAO.RentDAO;
import Time.Time;
import View.Components.BookList;
import View.Rent.RentView;
import javax.swing.Box;

/**
 *
 * @author Samuel
 */
public class RentController {
    
    private final RentView view;
    private final RentDAO rentDAO;
    private final BookDAO bookDAO;
    private final RentHelper helper;
    private BookList bookList;
    private boolean bookListVisible = false;
    
    public RentController(RentView view,RentDAO rentDAO) {
        
        this.view = view;
        this.rentDAO = rentDAO;
        this.helper = new RentHelper(view,rentDAO);
        this.bookDAO = new BookDAO();
        
        bookList = new BookList(Box.createVerticalBox(),bookDAO.selectAll());
        
        start();
    }
    
    public RentController(RentView view) {
        
        this.view = view;
        this.rentDAO = new RentDAO();
        this.helper = new RentHelper(view,rentDAO);
        this.bookDAO = new BookDAO();
        
        bookList = new BookList(Box.createVerticalBox(),bookDAO.selectAll());
        
        start();
    }
    
    public void start(){
        
        view.getjScrollPaneBookSearch().setVisible(false);
//        view.getjScrollPaneUserSearch().setVisible(false);
        
//        setBook(view.getChosenBook());
//        setUser(view.getChosenUser());
        
        loadDetails();
    }

    private void loadDetails() {
   
        Time time = Time.now();
        
        view.getjFormattedTextFieldRentDate().setText(time.getOnlyDate());
        
        time.addMonth(1);
        
        view.getjFormattedTextFieldReturnDate().setText(time.getOnlyDate());
        
        view.getjTextFieldPenalty().setText("1,00");
    }

    public void chooseBook() {
        
        
}
