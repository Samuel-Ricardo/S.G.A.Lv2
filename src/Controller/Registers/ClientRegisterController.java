/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Registers;

import DAO.StudentDAO;
import View.Registers.ClientRegister;

/**
 *
 * @author Samuel
 */
public class ClientRegisterController {

    private final StudentDAO studentDao;
    private final ClientRegisterHelper helper;
    private final ClientRegister view;

    public ClientRegisterController(ClientRegister view) {
        
        this.studentDao = new StudentDAO();
        this.helper = new ClientRegisterHelper();
        this.view = view;
    }
    
    public void register() {
       
        
    }    
    
}
