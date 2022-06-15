package com.ryan.database;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static DatabaseHandler handler;


//    public static void addMember(String id, String name, String email, String nickname) {
//        String qu="INSERT INTO MEMBER VALUES (" +
//                "'" + id + "',"+
//                "'" + name + "',"+
//                "'" + email + "',"+
//                "'" + nickname + "')";
//        handler.execAction(qu);
//    }

    public static void addFile(String file_name, String path, String extension, String file_size) {
        String qu="INSERT INTO " + DatabaseHandler.name +" (file_name, path, extension, file_size) VALUES (" +
                "'" + file_name + "',"+
                "'" + path + "',"+
                "'" + extension + "',"+
                "'" + file_size + "')";
        handler.execAction(qu);
    }

    public static void retrieveFile(String table) {
        String qu = "SELECT * FROM "+ table;
        ResultSet resultSet = handler.execQuery(qu);
        try{
            while (resultSet.next()){
                String file_name = resultSet.getString("FILE_NAME");
                String path = resultSet.getString("PATH");
                String extension = resultSet.getString("EXTENSION");
                String fileSize = resultSet.getString("FILE_SIZE");
                System.out.println("File Name: " + file_name + "\t| File Path: " + path + "\t| File Extension: "+ extension+"\t| File Size: " + fileSize );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ReadFiles(File folder){
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (!file.isDirectory()) {
                String fileName = file.getName();
                String filePath = file.getPath();
                String extension = "";
                int i = fileName.lastIndexOf('.');
                if (i > 0) {
                    extension = fileName.substring(i+1);
                }
                long fileSize = file.length();
                Main.addFile(fileName, filePath, extension, Long.toString(fileSize));
                System.out.println("File name = " + fileName + "\nFile path = " + filePath + "\nFile extension = " + extension + "\nFile size = " + fileSize);
            }else{
                ReadFiles(file);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("(1)if you already have files -->Print info\n(2)Start importing\n");
        if (scan.nextLine().equals("1")) { // Option for user to either input the absolute path of the folder and create table or check the old SQLs.
            System.out.println("Enter your folder name to retrieve your information: ");
            String tableName = scan.nextLine();
            handler = new DatabaseHandler(); // Set up a null handler since no folder name is given
            retrieveFile(tableName);
        } else if (scan.nextLine().equals("2")) {
            System.out.println("Enter the absolute path of your folder: ");
            String path = scan.nextLine();
            File folder = new File(path);
            DatabaseHandler.name= folder.getName();
            handler = DatabaseHandler.getHandler(); // Set up handler through folder name
            Main.ReadFiles(folder);
        } else {
            System.out.println("Return to main");
            main(null);
        }
    }
}
