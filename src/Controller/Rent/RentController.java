/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rent;

import DAO.RentDAO;
import View.Rent.RentView;

/**
 *
 * @author Samuel
 */
public class RentController {
    
    private RentView view;
    private RentDAO rentDAO;
    private RentHelper helper;

    public RentController(RentView view,RentDAO rentDAO, RentHelper helper) {
        
        this.view = view;
        this.rentDAO = rentDAO;
        this.helper = helper;
    }
}
