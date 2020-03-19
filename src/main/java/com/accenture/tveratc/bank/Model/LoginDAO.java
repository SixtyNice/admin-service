package com.accenture.tveratc.bank.Model;

import java.sql.*;


public class LoginDAO {


    private static String JDBC_DRIVER = "org.h2.Driver";
    private static String JDBC_URI = "jdbc:h2:~/test";
    private static String UsernameDB = "sa";
    private static String PasswordDB = "";

    public static boolean validate(String login, String password) {
        boolean status = false;

        try {
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(JDBC_URI, UsernameDB, PasswordDB);
            PreparedStatement statement = con.prepareStatement("select * from CLIENT where LOGIN=? and PASSWORD=?");
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            status = rs.next();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}
