/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.UserFactory;
import JDBC.ConnectionFactory;
import Model.User;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel
 */
public class UserDAO {
    
    private Connection connection;
    private String sql;
    private static Model.Interface.User loggedUser;

    public boolean insert(User client){
        
        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_client (client_name, client_login, client_password, client_access_level, client_image_perfil, client_email, client_address, client_cep, client_phone) VALUES (?,?,?,?,?,?,?,?,?);";

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, client.getName());
            statement.setString(2, client.getLogin());
            statement.setString(3, client.getPassword());
            statement.setInt(4, client.getAccessLevel());
            
            if(client.getPerfilImage() != null){
                
                statement.setString(5, client.getPerfilImage().getImageFile().getFile().getName());
            }
            
            statement.setString(6, client.getEmail());
            statement.setString(7, client.getAddress());
            statement.setString(8, client.getCEP());
            statement.setString(9, client.getPhone());
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
        
    }
    
    public boolean update(User client){
        
    connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_client SET client_name = ?, client_login = ?, client_password = ?, client_access_level = ?, client_image_perfil = ?, client_email = ?, client_address = ?, client_cep = ?, client_phone = ? WHERE id_client = ?;";
        
           
          try {
              
            statement = connection.prepareStatement(sql);
                      
            statement.setString(1, client.getName());
            statement.setString(2, client.getLogin());
            statement.setString(3, client.getPassword());
            statement.setInt(4, client.getAccessLevel());
            
            if(client.getPerfilImage() != null){
                
                statement.setString(5, client.getPerfilImage().getImageFile().getFile().getName());
            }
            
            statement.setString(6, client.getEmail());
            statement.setString(7, client.getAddress());
            statement.setString(8, client.getCEP());
            statement.setString(9, client.getPhone());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
    }

    
    public boolean delet(User client){
            
    connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_client WHERE id_client = ?;";
        

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, client.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
    }
    

    public List<User> selectAll(){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM client_view;";
        List<User> clients = new ArrayList<>();
   
          try {
              
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                User client = UserFactory.generateUser(result);
                
                clients.add(client);
            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return clients;
    }

    public List<User> search(String pesquisa){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM client_view WHERE client_name LIKE ? or login LIKE ?;";
        List<User> clients = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+pesquisa+"%");
            statement.setString(2, "%"+pesquisa+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
               User client = UserFactory.generateUser(result);
                
                clients.add(client);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return clients;
    }
    
    public boolean exist(String search){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM client_view WHERE client_name LIKE ? or login LIKE ?;";
            boolean exist = false;
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            statement.setString(2, "%"+search+"%");
            
            result = statement.executeQuery();
            
            exist = result.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }
    
    public User exist(String login, String password){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM client_view WHERE client_password = ? and client_login = ?;";
            User user = null;
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, password);
            statement.setString(2, login);
            
             result = statement.executeQuery();
            
            while(result.next()){
           
                user = UserFactory.generateUser(result);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    private void connect() {
     
        connection = ConnectionFactory.getConnection();

    }

    public static Model.Interface.User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(Model.Interface.User loggedUser) {
        UserDAO.loggedUser = loggedUser;
    }
}
