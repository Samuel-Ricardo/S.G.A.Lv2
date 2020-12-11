/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.ImageFile;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Samuel
 */
public class UserFactory {
    
    
    public static User generateUser(ResultSet result) throws SQLException {
        
        User user = new User();
        ImageFactory imageFactory = new ImageFactory();
        
        user.setId(result.getInt("id_client"));
        user.setName(result.getString("client_name"));
        user.setLogin(result.getString("client_login"));
        user.setPassword(result.getString("client_password"));
        user.setAccessLevel(result.getInt("client_access_level"));
        user.setPerfilImage(imageFactory.generateBackupImage(result));
        user.setEmail(result.getString("client_email"));
        user.setAddress(result.getString("client_address"));
        user.setCEP(result.getString("client_cep"));
        user.setPhone(result.getString("client_phone"));
        user.setAccessLevel(User.ACCESS_MIN);
        
        return user;
    }
    
    
}
