/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import Model.User;
import View.Researchers.ListOfBooks;
import View.MainMenu;
import View.Rent.RentWindow;

/**
 *
 * @author Samuel
 */
public class MainMenuController {
    
    public static MainMenu view;
    public static RentWindow RENT_WINDOW;

    public MainMenuController(MainMenu view) {
        
        MainMenuController.view = view;
        
    }
    
    public static void openBookList() {
   
        ListOfBooks bookList = new ListOfBooks();
        
        bookList.setVisible(true);
        
        MainMenuController.view.getDesktop().add(bookList);
    }

    public static void OpenRent(Book book, User user) {
       
        MainMenuController.RENT_WINDOW = new RentWindow(book, user);
   
        MainMenuController.RENT_WINDOW.setVisible(true);
        
        MainMenuController.view.getDesktop().add(MainMenuController.RENT_WINDOW);
    }
    
    
}
