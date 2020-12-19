/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rent;

import Controller.Helper.Rent.RentHelper;
import DAO.RentDAO;
import View.Rent.RentView;

/**
 *
 * @author Samuel
 */
public class RentController {
    
    private final RentView view;
    private final RentDAO rentDAO;
    private final RentHelper helper;

    public RentController(RentView view,RentDAO rentDAO) {
        
        this.view = view;
        this.rentDAO = rentDAO;
        this.helper = new RentHelper(view,rentDAO);
        
        start();
    }
    
    public RentController(RentView view) {
        
        this.view = view;
        this.rentDAO = new RentDAO();
        this.helper = new RentHelper(view,rentDAO);
        
        start();
    }
    
    public void start(){
    
        setBook(view.getC());
    }
}
