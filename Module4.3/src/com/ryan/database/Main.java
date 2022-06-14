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

    public static void addFile(String file name, String path, String extension, String size in bytes) {
        String qu="INSERT INTO FILES VALUES (" +
                "'" + file name + "',"+
                "'" + path + "',"+
                "'" + extension + "',"+
                "'" + size in bytes + "')";
        handler.execAction(qu);
    }


    public static void main(String[] args) {
        handler = new DatabaseHandler();

        String qu = "SELECT * FROM FILES";
        ResultSet resultSet = handler.execQuery(qu);
        try {
            while (resultSet.next()) {
                String fileName = resultSet.getString("FILENAME");
                String path = resultSet.getString("PATH");
                System.out.println("Entry: ID" + fileName + "\tPath: " + path);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
