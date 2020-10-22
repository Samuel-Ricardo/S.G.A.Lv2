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
import Model.ImageFile;
import Model.Manager;
import Model.Student;
import Model.User;
import Services.FileManager;
import Services.Dialoger;
import View.Login;
import View.MainMenu;
import java.io.File;

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
    private static File IMAGE_CACHE_FOLDER;
    private static File DATA_CACHE_FOLDER;

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
            Dialoger.message(view, "Usuário nao encntrado ou inexistente");
        }

    }

    private void openStar() {

        view.setVisible(false);

        MainMenu start = new MainMenu();
        start.setVisible(true);
    }

    public void start() {

        LoginController.setIMAGE_CACHE_FOLDER(filemanager.createFolder("Images"));
        LoginController.setDATA_CACHE_FOLDER(filemanager.createFolder("Data")); 
        
        
/////////////////////////// Exemplo de Copia de Arquivo ////////////////////////////////////////////////////         
//        String way = this.getClass().getResource("/View/Images/icons8-no-image-64px.png").getFile();
//        
//        File image = new File(way);
//        filemanager.copyFileTo(image, new File(FileManager.defaultFolderWay+"/Images/"+image.getName()));
/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    }

    public FileManager getFilemanager() {
        return filemanager;
    }

    public void setFilemanager(FileManager filemanager) {
        this.filemanager = filemanager;
    }

    public static File getIMAGE_CACHE_FOLDER() {
        return IMAGE_CACHE_FOLDER;
    }

    public static void setIMAGE_CACHE_FOLDER(File IMAGE_CACHE_FOLDER) {
        LoginController.IMAGE_CACHE_FOLDER = IMAGE_CACHE_FOLDER;
    }

    public static File getDATA_CACHE_FOLDER() {
        return DATA_CACHE_FOLDER;
    }

    public static void setDATA_CACHE_FOLDER(File DATA_CACHE_FOLDER) {
        LoginController.DATA_CACHE_FOLDER = DATA_CACHE_FOLDER;
    }
    
    
}

