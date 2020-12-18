/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.Book;
import Model.ImageFile;
import Model.Rent;
import Model.Student;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Samuel
 */
public class RentFactory {
    
     public static Rent generateRent(ResultSet result) throws SQLException {
         
        Rent rent = new Rent();
        
        rent.setId(result.getInt("id_rent"));
        rent.setRented(result.getDate("return_date"));
        rent.setReturnDate(result.getDate("return_date"));
        rent.setReturned(result.getBoolean("rent_returned"));
        rent.setPenality(result.getDouble("rent_penality"));
        rent.setObrservation(result.getString("rent_observation"));
        rent.setReturnedDate(result.getDate("returned_date"));
        rent.setBook(BookFactory.generateBook(result));
        
        if (result.getInt("id_student") != 0) {
            
            rent.setStudent(StudentFactory.generateStudent(result));
        }
        
        if (result.getInt("id_client") != 0) {
            
            rent.setClient(UserFactory.generateUser(result));
        }
        
        return rent;
    }
}
