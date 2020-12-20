/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rent;

import Controller.Helper.Rent.RentHelper;
import Controller.MainMenuController;
import DAO.RentDAO;
import Model.Book;
import Time.Time;
import View.Components.BookPane;
import View.Rent.RentWindow;
import View.Researchers.ListOfBooks;

/**
 *
 * @author Samuel
 */
public class RentController {
    
    private static RentWindow view;
    private static RentDAO rentDAO;
    private static RentHelper helper;

    
    public RentController(RentWindow view,RentDAO rentDAO) {
        
        this.view = view;
        this.rentDAO = rentDAO;
        this.helper = new RentHelper(view,rentDAO);
        
        start();
    }
    
    public RentController(RentWindow view) {
        
        this.view = view;
        this.rentDAO = new RentDAO();
        this.helper = new RentHelper(view,rentDAO);
        
        start();
    }
    
    public static void start(){
        
        if(view.getChosenBook() != null){
            
            loadBook(view.getChosenBook(), null);
        }
        
        loadDetails();
    }

    private static void loadDetails() {
   
        Time time = Time.now();
        
        view.getjFormattedTextFieldRentDate().setText(time.getOnlyDate());
        
        time.addMonth(1);
        
        view.getjFormattedTextFieldReturnDate().setText(time.getOnlyDate());
        
        view.getjTextFieldPenalty().setText("1,00");
    }

    public static void chooseBook() {
     
        MainMenuController.openBookList();
    }
    
    public static void loadBook(Book book, ListOfBooks parent) {
     
        BookPane pane = new BookPane(book, null, parent);
        
        view.getjPanelBookChosenBook().setVisible(true);
        view.getjPanelBookChosenBook().add(pane);
        
        view.getjPanelBookChosenBook().updateUI();
        view.getjPanelBookChosenBook().revalidate();
        view.getjPanelBookChosenBook().repaint();
        
        view.revalidate();
        view.repaint();
        view.updateUI();
    }
    
}
