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
import View.Rent.RentView;

/**
 *
 * @author Samuel
 */
public class MainMenuController {
    
    public static MainMenu view;
    public static RentView rentWindow;

    public MainMenuController(MainMenu view) {
        
        MainMenuController.view = view;
        
    }
    
    public static void openBookList() {
   
        ListOfBooks bookList = new ListOfBooks();
        
        bookList.setVisible(true);
        
        MainMenuController.view.getDesktop().add(bookList);
    }

    public static void OpenRent(Book book, User user) {
       
        MainMenuController.rentWindow = new RentView(MainMenuController.view, true, book, user);
   
        MainMenuController.rentWindow.setVisible(true);
        
        MainMenuController.view.getDesktop().add(MainMenuController.rentWindow);
    }
    
    
}
