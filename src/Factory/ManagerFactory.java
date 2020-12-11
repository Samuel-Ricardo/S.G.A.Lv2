/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.ImageFile;
import Model.Manager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Samuel
 */
public class ManagerFactory {

    public static Manager generateManager(ResultSet result) throws SQLException {

        Manager manager = new Manager();
        ImageFactory imageFactory = new ImageFactory();

        manager.setId(result.getInt("id_user"));
        manager.setName(result.getString("user_name"));
        manager.setLogin(result.getString("user_login"));
        manager.setPassword(result.getString("user_password"));
        manager.setAccessLevel(result.getInt("user_access_level"));

        if (imageFactory.generateBackupImage(result) != null) {

            manager.setPerfilImage(imageFactory.generateBackupImage(result));

        }

        manager.setEmail(result.getString("user_email"));
        manager.setAddress(result.getString("user_address"));
        manager.setCEP(result.getString("user_cep"));
        manager.setPhone(result.getString("user_phone"));
        manager.setSchool(result.getString("user_school"));

        return manager;
    }
}
