package com.accenture.tveratc.bank.Model;

import com.accenture.tveratc.bank.entity.Client;

import java.sql.*;
import java.util.Properties;
import java.util.UUID;


public class LoginDAO {


    private static Client client;

    public static boolean validate(String login, String password) {
        boolean status = false;


        Connection con = null;
        Properties properties = new Properties();

        try {
            String JDBC_DRIVER =  properties.getProperty("db.driver");
            Class.forName(JDBC_DRIVER);
            String passwordDB = properties.getProperty("db.password");
            String usernameDB = properties.getProperty("db.user");
            String JDBC_URI = properties.getProperty("db.url");
            con = DriverManager.getConnection(JDBC_URI, usernameDB, passwordDB);
            PreparedStatement statement = con.prepareStatement("select * from CLIENT where LOGIN=? and PASSWORD=?");
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            status = rs.next();
            if (status) {
                UUID id = UUID.fromString(rs.getString("ID"));
                String name = rs.getString("NAME");
                String lastName = rs.getString("LAST_NAME");
                String middle_name = rs.getString("MIDDLE_NAME");
                String role = rs.getString("ROLE");
                client = new Client(id, login, password, name, lastName, middle_name, role);
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Client getClientInfo() {
        return client;
    }
}
