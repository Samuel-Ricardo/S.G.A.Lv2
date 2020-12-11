/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DAO.ImageDAO;
import Model.BackupImage;
import Model.ImageFile;
import Model.Student;
import Model.User;
import Services.FileManager;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class StudentFactory {
    
        public static Student generateStudent(ResultSet result) throws SQLException {
        
        Student student = new Student();
        
            System.out.println("Criando estudante");
        
        student.setId(result.getInt("id_student"));
        student.setName(result.getString("student_name"));
        student.setLogin(result.getString("student_login"));
        student.setPassword(result.getString("student_password"));
        student.setCEP(result.getString("student_CEP"));
        student.setAddress(result.getString("student_address"));
        student.setEmail(result.getString("student_email"));
        student.setCourse(result.getString("student_course"));
        student.setModule(result.getString("student_module"));
        student.setPhone(result.getString("student_phone"));
        student.setSchool(result.getString("student_school"));
        student.setRegistration(result.getString("student_registration"));
        student.setGrade(result.getString("student_grade"));
        student.setSchool(result.getString("student_school"));
        student.setShift(result.getString("student_shift"));
        student.setAccessLevel(User.ACCESS_MIN);
        
            saveImageOnstudent(result.getString("student_image_perfil"), student, new ImageDAO());
            
        return student;
    }   
        
        public static void saveImageOnstudent(String imageName, Student student, ImageDAO imageDao) throws SQLException {

        if(imageName != null){
            
            File file = FileManager.getFileInDefaultFolder("Images/"+imageName);
            
            if(file.exists()){
                
                BackupImage backupImage = setLocalImage(file, student);
                
                BookFactory.insertImageIfNotExist(imageDao, backupImage);
            }else{
                
                List<BackupImage> searchByName = imageDao.searchByName(imageName);
                
                if(searchByName.isEmpty() == false){
                    
                    student.setPerfilImage(searchByName.get(0));
                }
            }     
        }
    }

    private static BackupImage setLocalImage(File file, Student student) {
        
        ImageFile imageFile = new ImageFile(file);
        BackupImage backupImage = new BackupImage();
        backupImage.setImageFile(imageFile);
        
        student.setPerfilImage(backupImage); 
        
        return backupImage;
    }
}
