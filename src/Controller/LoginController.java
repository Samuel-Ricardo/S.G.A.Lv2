/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import DAO.ManagerDAO;
import DAO.StudentDAO;
import DAO.UserDAO;
import Model.Manager;
import Model.Student;
import Model.User;
import Services.FileManager;
import View.Dialoguer;
import View.Login;
import View.Start;

/**
 *
 * @author Samuel
 */
public class LoginController {

    private final Login view;
    private final LoginHelper helper;
    private final UserDAO userDAO;
    private final StudentDAO studntDAO;
    private final ManagerDAO managerDAO;
    private FileManager filemanager;

    public LoginController(Login view) {

        this.view = view;
        this.helper = new LoginHelper(view);
        this.userDAO = new UserDAO();
        this.studntDAO = new StudentDAO();
        this.managerDAO = new ManagerDAO();
        this.filemanager = new FileManager();
    }

    public void logInto() {

        String login = helper.getLogin();
        String password = helper.getPassword();
        boolean logged = false;

        Manager manager = managerDAO.exist(login, password);

        if (manager != null) {

            UserDAO.setLoggedUser(manager);
            logged = true;
            openStar();
            return;
        }

        User user = userDAO.exist(login, password);

        if (user != null) {

            UserDAO.setLoggedUser(user);
            logged = true;
            openStar();
            return;

        }

        Student student = studntDAO.exist(login, password);

        if (student != null) {

            UserDAO.setLoggedUser(student);
            logged = true;
            openStar();
            return;
        }
        
        if(logged == false){
            Dialoguer.message(view, "Usuário nao encntrado ou inexistente");
        }

    }

    private void openStar() {

        view.setVisible(false);

        Start start = new Start();
        start.setVisible(true);
    }

    public void start() {

        filemanager.createFolder("Images");
    
    }
}
