package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
    static Connection con;
    public static Connection createC() throws ClassNotFoundException, SQLException {
        //we are calling it static because jvm call directly without calling object
        //load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //create the connection
        String user="root";
        String password="8572008222";
        String url="jdbc:mysql://localhost:3306/student_manage";
        con=DriverManager.getConnection(url,user,password);
        //our connection will be return here
        return con;
    }

}
