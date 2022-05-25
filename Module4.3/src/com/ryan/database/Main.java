package com.ryan.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static DatabaseHandler handler;
    public static void addMember(String id, String name, String email, String nickname) {
        String qu="INSERT INTO MEMBER VALUES (" +
                "'" + id + "',"+
                "'" + name + "',"+
                "'" + email + "',"+
                "'" + nickname + "')";
        handler.execAction(qu);
    }
    public static void main(String[] args) {
        handler = new DatabaseHandler();
        //addMember("23456","asdasd","asdasd","asdas");
        String qu = "SELECT * FROM MEMBER";
        ResultSet resultSet = handler.execQuery(qu);
        try {
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String name = resultSet.getString("NAME");
                System.out.println("Entry: ID" + id + "\tName: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
