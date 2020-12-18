/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Researchers.ListOfBooks;
import View.MainMenu;
import View.Rent.Rent;

/**
 *
 * @author Samuel
 */
public class MainMenuController {
    
    private final MainMenu view;

    public MainMenuController(MainMenu view) {
        this.view = view;
    }

    public void openBookList() {
   
        ListOfBooks bookList = new ListOfBooks();
        bookList.setVisible(true);
        view.getDesktop().add(bookList);
    }

    public void OpenRent() {
       
        Rent rent = new Rent(view, true, null, null);
        
        rent.setVisible(true);
        view.getDesktop().add(rent);
    }
    
    
}
