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
       
        RentView rent = new RentView(view, true, new Book(), new User());
        
        rent.setVisible(true);
        view.getDesktop().add(rent);
    }
    
    
}
