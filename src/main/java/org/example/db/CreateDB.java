package org.example.db;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
    public static Connection createDBConnection(){
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "pass";

        try{
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return connection;
    }
}
