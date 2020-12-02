/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ClientFactory;
import JDBC.ConnectionFactory;
import Model.Client;
import Services.Dialoger;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hylan
 */
public class ClientDAO {

    private Connection connection;
    private String sql;

    public boolean Insert(Client client) {
        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_client (client_name, cliente_loguin, client_password, client_CEP, client_address, client_phone, client_email, client_image_perfil) VALUES (?,?,?,?,?,?,?,?);";

        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, client.getName());
            statement.setString(2, client.getLogin());
            statement.setString(3, client.getPassword());
            statement.setString(4, client.getCEP());
            statement.setString(5, client.getAddress());
            statement.setString(6, client.getPhone());
            statement.setString(7, client.getEmail());
            statement.setString(8, client.getPerfilImage().getImageFile().getFile().getName());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Salvar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public boolean update(Client client) {

        connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_client SET client_name = ?, cliente_loguin = ?, client_password = ?, client_CEP = ?, client_address = ?, client_phone = ?, client_email = ?, client_image_perfil = ? WHERE id_student = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, client.getName());
            statement.setString(2, client.getLogin());
            statement.setString(3, client.getPassword());
            statement.setString(4, client.getCEP());
            statement.setString(5, client.getAddress());
            statement.setString(6, client.getPhone());
            statement.setString(7, client.getEmail());
            statement.setString(8, client.getPerfilImage().getImageFile().getFile().getName());
            statement.setInt(9, client.getId().intValue());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Atualizar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public boolean delete(Client client) {
        connect();
        PreparedStatement statement = null;
        sql = "DELETE FRON tb_client WHERE id_student = ?;";

        try {

            statement = connection.clientPrepareStatement(sql);

            statement.setInt(1, client.getId().intValue());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Deletar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Client> selectAll() {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_client;";
        List<Client> clients = new ArrayList<>();

        try {

            statement = connection.prepareStatement(sql);

            result = statement.executeQuery();

            while (result.next()) {

                Client client = ClientFactory.generateClient(result);

                clients.add(client);
            }
        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Pesquisar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return clients;
    }

    public List<Client> search(String pesquisa) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_client WHERE nome LIKE ? or loguin LIKE ?;";
        List<Client> clients = new ArrayList<>();

        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + pesquisa + "%");
            statement.setString(2, "%" + pesquisa + "%");

            result = statement.executeQuery();

            while (result.next()) {

                Client client = ClientFactory.generateClient(result);

                clients.add(client);
            }
        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Pesquisar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return clients;
    }

    public boolean exist(String pesquisa) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_client WHERE nome LIKE ? or loguin LIKE ?;";
        boolean exist = false;

        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + pesquisa + "%");
            statement.setString(2, "%" + pesquisa + "%");

            result = statement.executeQuery();

            exist = result.next();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }
    
    public Client exist(String login, String password){
        
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM client_view WHERE student_password = ? and student_login = ?;";
        Client client = null;
        
        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, password);
            statement.setString(2, login);

            result = statement.executeQuery();
            
            while (result.next()) {

                client = ClientFactory.generateClient(result);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
    private void connect() {

        connection = ConnectionFactory.getConnection();
    }
}
