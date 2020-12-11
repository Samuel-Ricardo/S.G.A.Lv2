/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.ImageFile;
import Model.Client;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hylan
 */
public class ClientFactory {

    public static Client generateClient(ResultSet result) throws SQLException {

        Client client = new Client();
        ImageFactory imageFactory = new ImageFactory();
        
        client.setId(result.getInt("id_name"));
        client.setName(result.getString("client_name"));
        client.setLogin(result.getString("client_loguin"));
        client.setPassword(result.getString("client_password"));
        client.setCEP(result.getString("client_CEP"));
        client.setAddress(result.getString("client_address"));
        client.setPhone(result.getString("client_phone"));
        client.setEmail(result.getString("cleint_email"));
        client.setPerfilImage(imageFactory.generateBackupImage(result));
        client.setAccessLevel(User.ACCESS_MIN);

        return client;
    }
}
