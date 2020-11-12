/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Registers;

import Controller.Helper.ClientRegisterHelper;
import DAO.StudentDAO;
import Model.ImageFile;
import Model.Student;
import Services.Dialoger;
import Services.FileManager;
import View.Registers.StudentRegistrationView;
import javax.swing.JFileChooser;

/**
 *
 * @author Samuel
 */
public class StudentRegisterController {

    private final StudentDAO studentDao;
    private final ClientRegisterHelper helper;
    private final StudentRegistrationView view;
    private final FileManager fileManager;

    public StudentRegisterController(StudentRegistrationView view) {
        
        this.studentDao = new StudentDAO();
        this.helper = new ClientRegisterHelper(view);
        this.view = view;
        fileManager = new FileManager();
    }
    
    public void register() {
       
        Student student = helper.getStudent();
        
        fileManager.copyFileTo(student.getPerfilImage().getFile(), fileManager.getFile("Images"));
        
       if (studentDao.insert(student)){
        
           Dialoger.message(view, "Salvo com sucesso");
       }
    }    

    public void choseImage() {
   
        JFileChooser chooser = new JFileChooser();
        
        if (chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION){
        
            ImageFile image = new ImageFile(chooser.getSelectedFile());
            
            ImageFile.resizeImageByPath(view.getjLabelPerfilImage(), image.getFile().getAbsolutePath());
            
            view.setPerfilImage(image);
            //view.getjLabelPerfilImage().updateUI();
        }
    }
    
}
