/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ManagerFactory;
import JDBC.ConnectionFactory;
import Model.Manager;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManagerDAO {
    
    private Connection connection;
    private String sql;
    private static Manager loggedManeger;

    public boolean insert(Manager user){
        
        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_user (user_name, user_login, user_password, user_access_level, user_image_perfil, user_email, user_address, user_cep, user_phone, user_school) VALUES (?,?,?,?,?,?,?,?,?,?);";

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getAccessLevel());
            statement.setString(5, user.getPerfilImage().getImageFile().getFile().getName());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getCEP());
            statement.setString(9, user.getPhone());
            statement.setString(10, user.getSchool());
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
        
    }
    
    public boolean update(Manager user){
        
    connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_user SET user_name = ?, user_login = ?, user_password = ?, user_access_level = ?, user_image_perfil = ?,user_image_name = ? , user_email = ?, user_address = ?, user_cep = ?, user_phone = ?, user_school = ? WHERE id_user = ?;";
        
           
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getAccessLevel());
            statement.setString(5, user.getPerfilImage().getImageFile().getFile().getName());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getCEP());
            statement.setString(9, user.getPhone());
            statement.setString(10, user.getSchool());
            statement.setInt(11, user.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
    }

    
    public boolean delet(Manager user){
            
    connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_user WHERE id_user = ?;";
        

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, user.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
    }
    

    public List<Manager> selectAll(){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_user;";
        List<Manager> users = new ArrayList<>();
   
          try {
              
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                Manager user = ManagerFactory.generateManager(result);
                
                users.add(user);
            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return users;
    }
    
    public List<Manager> search(String pesquisa){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_user WHERE user_name LIKE ? or login LIKE ?;";
        List<Manager> users = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+pesquisa+"%");
            statement.setString(2, "%"+pesquisa+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
               Manager user = ManagerFactory.generateManager(result);
                
                users.add(user);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return users;
    }
    
    public boolean exist(String search){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_user WHERE user_name LIKE ? or login LIKE ?;";
            boolean exist = false;
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            statement.setString(2, "%"+search+"%");
            
            result = statement.executeQuery();
            
            exist = result.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }
    
    public Manager exist(String login, String password){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM user_view WHERE user_password = ? and user_login = ?;";
            Manager manager = null;
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, password);
            statement.setString(2, login);
            
             result = statement.executeQuery();
            
            while(result.next()){
           
                manager = ManagerFactory.generateManager(result);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return manager;
    }
    
    private void connect() {
     
        connection = ConnectionFactory.getConnection();

    }
    
}
