/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.StudentFactory;
import JDBC.ConnectionFactory;
import Model.Student;
import Services.Dialoger;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Samuel & Hylan 
 */
public class StudentDAO {

    private Connection connection;
    private String sql;

    public boolean insert(Student student) {

        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_student (student_name, student_login, student_password, student_registration, student_image_perfil, student_email , student_CEP, student_phone, student_school, student_Address, student_module, student_grade, student_course, student_shift) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getLogin());
            statement.setString(3, student.getPassword());
            statement.setString(4, student.getRegistration());
            statement.setString(5, student.getPerfilImage().getImageFile().getFile().getName());
            statement.setString(6, student.getEmail());
            statement.setString(7, student.getCEP());
            statement.setString(8, student.getPhone());
            statement.setString(9, student.getSchool());
            statement.setString(10, student.getAddress());
            statement.setString(11, student.getModule());
            statement.setString(12, student.getGrade());
            statement.setString(13, student.getCourse());
            statement.setString(14, student.getShift());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Salvar: " + ex);
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public boolean update(Student student) {

        connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_student SET student_name = ? , student_login = ?, student_password = ?, student_registration = ?, student_image_perfil = ?, student_email = ?,  student_CEP = ?, student_phone = ?, student_school = ?, student_Address = ?, student_module = ?, student_grade = ?, student_course = ?, student_shift = ? WHERE id_student = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getLogin());
            statement.setString(3, student.getPassword());
            statement.setString(4, student.getRegistration());
            statement.setString(5, student.getPerfilImage().getImageFile().getFile().getName());
            statement.setString(6, student.getEmail());
            statement.setString(7, student.getCEP());
            statement.setString(8, student.getPhone());
            statement.setString(9, student.getSchool());
            statement.setString(10, student.getAddress());
            statement.setString(11, student.getModule());
            statement.setString(12, student.getGrade());
            statement.setString(13, student.getCourse());
            statement.setString(14, student.getShift());
            statement.setInt(15, student.getId().intValue());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Atualizar: " + ex);
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public boolean delet(Student student) {

        connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_student WHERE id_student = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setInt(1, student.getId().intValue());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Deletar: " + ex);
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Student> selectAll() {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_student;";
        List<Student> students = new ArrayList<>();

        try {

            statement = connection.prepareStatement(sql);

            result = statement.executeQuery();

            while (result.next()) {

                Student student = StudentFactory.generateStudent(result);

                students.add(student);
            }

        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Pesqisar: " + ex);
            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return students;
    }

    public List<Student> fastSearch(String pesquisa) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_student WHERE student_name LIKE ? or student_login LIKE ? or student_registration = ?;";
        List<Student> students = new ArrayList<>();

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + pesquisa + "%");
            statement.setString(2, "%" + pesquisa + "%");
            statement.setString(3, "%" + pesquisa + "%");

            result = statement.executeQuery();

            while (result.next()) {

                Student student = StudentFactory.generateStudent(result);

                students.add(student);

            }

        } catch (SQLException ex) {
            Dialoger.message(null, "Erro ao Pesqisar: " + ex);
            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return students;
    }
    
    public List<Student> deepSearch(String pesquisa) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_student WHERE student_name LIKE ? OR student_registration LIKE ? OR student_email LIKE ? OR student_phone LIKE ? OR student_CEP LIKE ? OR student_address LIKE ? OR student_module LIKE ? OR student_grade LIKE ? OR student_course LIKE ? OR student_school LIKE ? OR student_shift LIKE ? OR student_shift LIKE ? OR student_login LIKE ?;";
        ArrayList<Student> students = new ArrayList<>();

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + pesquisa + "%");
            statement.setString(2, "%" + pesquisa + "%");
            statement.setString(3, "%" + pesquisa + "%");
            statement.setString(4, "%" + pesquisa + "%");
            statement.setString(5, "%" + pesquisa + "%");
            statement.setString(6, "%" + pesquisa + "%");
            statement.setString(7, "%" + pesquisa + "%");
            statement.setString(8, "%" + pesquisa + "%");
            statement.setString(9, "%" + pesquisa + "%");
            statement.setString(10, "%" + pesquisa + "%");
            statement.setString(11, "%" + pesquisa + "%");
            statement.setString(12, "%" + pesquisa + "%");
            statement.setString(13, "%" + pesquisa + "%");

            result = statement.executeQuery();

            while(result.next()){
                
                Student student = StudentFactory.generateStudent(result);
                
                students.add(student);
            }

        } catch (SQLException ex) {
             Dialoger.message(null, "Erro ao Pesqisar: " + ex);
            ex.printStackTrace();
        }
        return students;
    }

    public boolean exist(String pesquisa) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_student WHERE student_name LIKE ? OR student_login LIKE ?;";
        boolean exist = false;

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + pesquisa + "%");
            statement.setString(2, "%" + pesquisa + "%");

            result = statement.executeQuery();

            exist = result.next();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
        return exist;
    }

    public Student exist(String login, String password) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM student_view WHERE student_password = ? and student_login = ?;";
        Student student = null;

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, password);
            statement.setString(2, login);

            result = statement.executeQuery();

            while (result.next()) {

                student = StudentFactory.generateStudent(result);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return student;
    }

    private void connect() {

        connection = ConnectionFactory.getConnection();

    }

}
