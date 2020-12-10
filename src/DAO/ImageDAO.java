/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template backupImage, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ImageFactory;
import JDBC.ConnectionFactory;
import Model.BackupImage;
import Model.Book;
import Services.Dialoger;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class ImageDAO {

    private static BackupImage backupImage;
    
    private Connection connection;
    private ImageFactory imageFactory; 
    private Dialoger dialoger;

    public ImageDAO() {
        
      imageFactory = new ImageFactory();
      dialoger = new Dialoger();
    }
    
    public ImageDAO(ImageFactory backupImageFactory) {
        
        this.imageFactory = backupImageFactory;
        dialoger = new Dialoger();
    }

    public boolean insert(BackupImage backupImage) {
        
        connect();
         
        PreparedStatement statement = null;
        String sql = "INSERT INTO tb_images (image_name, image_way, image_bytes) VALUES (?,?,?);";

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, backupImage.getImageFile().getFile().getName());
            statement.setString(2, backupImage.getImageFile().getFile().getAbsolutePath());
            statement.setBinaryStream(3, backupImage.getImageFile().getInputStream());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao Inserir: ", ex);  // error message if it occurs // mensagem de erro se ocorrer /
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public boolean update(BackupImage backupImage) {

        connect();
         
        PreparedStatement statement = null;
        String sql = "UPDATE tb_images SET image_name = ? , image_way = ? , image_bytes = ? WHERE id_images = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, backupImage.getImageFile().getFile().getName());
            statement.setString(2, backupImage.getImageFile().getFile().getAbsolutePath());
            statement.setBinaryStream(3, backupImage.getImageFile().getInputStream());
          //statement.setString(4, backupImage.getImageFile().getLengthKB()+"");
            statement.setInt(4, backupImage.getId().intValue());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao Atualizar : ", ex);  // error message if it occurs // mensagem de erro se ocorrer /
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public boolean delet(BackupImage backupImage) {

        connect();

        PreparedStatement statement = null;
        String sql = "DELETE FROM tb_images WHERE id_images = ?;";

        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, backupImage.getId());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
            dialoger.errorMessage(null,"Erro ao Deletar: ", ex);  // error message if it occurs // mensagem de erro se ocorrer /
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }
    
    public List<BackupImage> searchByName (String name) {

        connect();
     
        PreparedStatement statement = null;
        ResultSet result = null;
        List<BackupImage> backupImages = new ArrayList<>();
        String sql = "SELECT * FROM tb_images WHERE image_name = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, name);

            result = statement.executeQuery();

            while (result.next()) {

                BackupImage backupImage = imageFactory.generateBackupImage(result);
                
                backupImages.add(backupImage);
                
            }

        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao consultar o banco: ", ex);  // error message if it occurs // mensagem de erro se ocorrer /
        } finally {
            ConnectionFactory.closeConnection(connection, statement);  // closes all connections regardless of success  // fecha todas as conexoes independente de sucesso
        }
        
        return backupImages;
    }
    
    public boolean exist(BackupImage backupImage) {  
        
        connect();
        
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM tb_images WHERE id_images = ?;";
        boolean exist = false;

        try {

            statement = connection.prepareStatement(sql);    
            
            statement.setInt(1, backupImage.getId().intValue());    
            
            result = statement.executeQuery();           
            
            exist = result.next();

        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao consultar o banco: ", ex); 
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement); 
        }

        return exist;
        
    }
    
    public ArrayList<Boolean> exist(ArrayList<BackupImage> backupImages) {  
        
        ArrayList<Boolean> exist = new ArrayList<>();
        
        for(BackupImage backupImage: backupImages){
            
         if(backupImage.getId() == null){
            exist.clear();
            exist.add(false);
            return exist;
         }
         
        }

        connect();
        
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM tb_images WHERE id_images = ?;";
        

       
        
        try {

         for (BackupImage backupImage : backupImages) {
                
            statement = connection.prepareStatement(sql);    
            
            statement.setInt(1, backupImage.getId().intValue());    
            
            result = statement.executeQuery();           
            
            exist.add(result.next());
        }

        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao consultar o banco: ", ex);
            exist.clear();
            exist.add(false);
            return exist;
        } finally {
            ConnectionFactory.closeConnection(connection, statement); 
        }

        return exist;
    }

    public boolean existByName(BackupImage backupImage) {

        connect();
        
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM tb_images WHERE image_name = ?;";
        boolean exist = false;

        try {

            statement = connection.prepareStatement(sql);    
            
            statement.setString(1, backupImage.getImageFile().getFile().getName());     
            
            result = statement.executeQuery();           
            
            exist = result.next();

        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao consultar o banco: ", ex); 
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement); 
        }

        return exist;
        
    }
    
    public ArrayList<Boolean> existByName(ArrayList<BackupImage> backupImages) {  
        
        ArrayList<Boolean> exist = new ArrayList<>();
        
        for(BackupImage backupImage: backupImages){
            
         if(backupImage.getId() == null){
            exist.clear();
            exist.add(false);
            return exist;
         }
         
        }

        connect();
        
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM tb_images WHERE image_name = ?;";
        

       
        
        try {

         for (BackupImage backupImage : backupImages) {
                
            statement = connection.prepareStatement(sql);    
            
            statement.setString(1, backupImage.getImageFile().getFile().getName());    
            
            result = statement.executeQuery();           
            
            exist.add(result.next());
        }

        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao consultar o banco: ", ex);
            exist.clear();
            exist.add(false);
            return exist;
        } finally {
            ConnectionFactory.closeConnection(connection, statement); 
        }

        return exist;
    }
    
    public boolean existByPath(BackupImage backupImage) {

        connect();
        
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM tb_images WHERE image_way = ?;";
        boolean exist = false;

        try {

            statement = connection.prepareStatement(sql);    
            
            statement.setString(1, backupImage.getImageFile().getFile().getAbsolutePath());     
            
            result = statement.executeQuery();           
            
            exist = result.next();

        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao consultar o banco: ", ex); 
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement); 
        }

        return exist;
        
    }
    
    public ArrayList<Boolean> existByPath(ArrayList<BackupImage> backupImages) {  
        
        ArrayList<Boolean> exist = new ArrayList<>();
        
        for(BackupImage backupImage: backupImages){
            
         if(backupImage.getId() == null){
            exist.clear();
            exist.add(false);
            return exist;
         }
         
        }

        connect();
        
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM tb_images WHERE image_way = ?;";
        

       
        
        try {

         for (BackupImage backupImage : backupImages) {
                
            statement = connection.prepareStatement(sql);    
            
            statement.setString(1, backupImage.getImageFile().getFile().getAbsolutePath());    
            
            result = statement.executeQuery();           
            
            exist.add(result.next());
        }

        } catch (SQLException ex) {
            dialoger.errorMessage(null,"Erro ao consultar o banco: ", ex);
            exist.clear();
            exist.add(false);
            return exist;
        } finally {
            ConnectionFactory.closeConnection(connection, statement); 
        }

        return exist;
    }

       private void connect() {
        connection = ConnectionFactory.getConnection();
    }
}
