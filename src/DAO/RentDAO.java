/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.RentFactory;
import JDBC.ConnectionFactory;
import Model.Rent;
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
public class RentDAO {

    private Connection connection;
    private String sql;
    private static Rent selectedRent;
    private String imageName;
    
    public boolean insert(Rent rent) {

        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_rent (rented_date, id_of_book, id_of_student, id_of_client, rent_returned, rent_penality, rent_observation, returned_date) VALUES (?,?,?,?,?,?,?,?);";

        try {

            statement = connection.prepareStatement(sql);

            statement.setDate(1, rent.getRentedDate().toSQLDate());
            statement.setInt(2, rent.getBook().getId().intValue());
            statement.setInt(3, rent.getStudent().getId().intValue());
            statement.setInt(4, rent.getClient().getId().intValue());
            statement.setDate(6, rent.getReturnDate().toSQLDate());
            statement.setBoolean(7, rent.isReturned());
            statement.setDouble(8, rent.getPenality());
            statement.setString(9, rent.getObrservation());
            statement.setDate(10, rent.getReturnDate().toSQLDate());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public boolean update(Rent rent) {

        connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_rent SET rented_date = ?, id_of_book = ?, id_of_student = ?, id_of_client = ?, rent_returned = ?, rent_penality = ?, rent_observation = ?, returned_date = ? WHERE id_rent = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setDate(1, rent.getRentedDate().toSQLDate());
            statement.setInt(2, rent.getBook().getId().intValue());
            statement.setInt(3, rent.getStudent().getId().intValue());
            statement.setInt(4, rent.getClient().getId().intValue());
            statement.setDate(6, rent.getReturnDate().toSQLDate());
            statement.setBoolean(7, rent.isReturned());
            statement.setDouble(8, rent.getPenality());
            statement.setString(9, rent.getObrservation());
            statement.setDate(10, rent.getReturnDate().toSQLDate());
            statement.setInt(11, rent.getId().intValue());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public boolean delet(Rent rent) {

        connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_rent WHERE id_rent = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setInt(1, rent.getId().intValue());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Rent> selectAll() {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM data_of_rents_view;";
        List<Rent> rents = new ArrayList<>();
        String imageName = "";

        try {

            statement = connection.prepareStatement(sql);

            result = statement.executeQuery();

            while (result.next()) {

                Rent rent = RentFactory.generateRent(result);

                rents.add(rent);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return rents;
    }

    public List<Rent> search(String method, String search) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM data_of_rents_view WHERE " + method + " LIKE ?;";
        List<Rent> rents = new ArrayList<>();

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            result = statement.executeQuery();

            while (result.next()) {

                rents.add(RentFactory.generateRent(result));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return rents;
    }

    public boolean exist(String search) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM data_of_rents_view WHERE book_name LIKE ? or student_name LIKE ? or client_name LIKE ?;";
        boolean exist = false;

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            result = statement.executeQuery();

            exist = result.next();

        } catch (SQLException ex) {
            Logger.getLogger(RentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }

    private void connect() {

        connection = ConnectionFactory.getConnection();

    }

}
