/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rent;

import Controller.Helper.Rent.RentHelper;
import DAO.RentDAO;
import Model.Book;
import Model.User;
import Time.Time;
import View.Components.BookList;
import View.Rent.RentView;

/**
 *
 * @author Samuel
 */
public class RentController {
    
    private final RentView view;
    private final RentDAO rentDAO;
    private final RentHelper helper;
    private BookList bookList;
    private boolean bookListVisible = false;
    
    public RentController(RentView view,RentDAO rentDAO) {
        
        this.view = view;
        this.rentDAO = rentDAO;
        this.helper = new RentHelper(view,rentDAO);
        
        bookList = new BookList();
        
        start();
    }
    
    public RentController(RentView view) {
        
        this.view = view;
        this.rentDAO = new RentDAO();
        this.helper = new RentHelper(view,rentDAO);
        
        bookList = new BookList();
        
        start();
    }
    
    public void start(){
        
        view.getjPanelBookSearch().setVisible(false);
        view.getjPanelUserSearch().setVisible(false);
        
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
        
        bookListVisible = !bookListVisible;
        
        bookList.setVisible(bookListVisible);
        
        view.getjPanelBookSearch().setVisible(bookListVisible);
        
        if(bookListVisible = true){
         view.getjPanelBookSearch().add(bookList.getInstance(view.getjPanelBookSearch().getSize()));
        }
    }
}
