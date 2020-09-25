/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Time.Time;
import View.Registers.BookRegistrationView;
import java.util.Date;

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

    public void fillFormatedText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getStock() {
   
       return (int) view.getJsBookStok().getValue();
    }

    public Time getAcquiredDate() {
       
    String stringDate = view.getjFormattedTextFieldAcquisition().getText();
        
    Time time = new Time(stringDate);
    
    return time;
    }

}
