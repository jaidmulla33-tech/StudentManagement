package org.example.dao;
import org.example.model.Student;
import org.example.db.CreateDB;

import java.sql.*;

public class StudentDAO {

    //********** Get Student By Id ************//
    public static Student getStudentById(int studentId){
        Connection connection = CreateDB.createDBConnection();
        Student student = null;

        try{
            String query = "SELECT * FROM STUDENTS WHERE SID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet set = preparedStatement.executeQuery();
            if(set.next()){
                String name = set.getString("SNAME");
                String phone = set.getString("SPHONE");
                String email = set.getString("SEMAIL");
                String city = set.getString("SCITY");
                student = new Student(name, phone, email, city);
            }
        }catch (SQLException e){
            System.out.println("Oops, Try again!");
            e.printStackTrace();
        }finally {
            try{
                if(connection != null && !connection.isClosed()) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return student;
    }

    //********* Add Student To Database **********//
    public static boolean addStudentToDB(Student student){
        Connection connection = CreateDB.createDBConnection();
        boolean flag = false;

        try {
            String query = "INSERT INTO STUDENTS(SNAME, SPHONE, SEMAIL, SCITY) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentPhone());
            preparedStatement.setString(3, student.getStudentEmail());
            preparedStatement.setString(4, student.getStudentCity());
            preparedStatement.executeUpdate();
            flag = true;
        }catch (SQLException e){
            System.out.println("Oops, Try again!");
            e.printStackTrace();
        }finally {
            try{
                if(connection != null && !connection.isClosed()) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return flag;
    }

    //*********** Delete Student From The Database ***********//
    public static boolean deleteStudentFromDB(int studentId){
        Connection connection = CreateDB.createDBConnection();
        boolean flag = false;

        try{
            String query = "DELETE FROM students WHERE SID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
            flag = true;

            //Check Table empty or not to reset the index number.
            Statement checkStatement = connection.createStatement();
            ResultSet countSet = checkStatement.executeQuery("SELECT COUNT(*) FROM students");

            if(countSet.next() && countSet.getInt(1) == 0){
                Statement resetStatement = connection.createStatement();
                resetStatement.executeUpdate("ALTER TABLE students AUTO_INCREMENT = 1");
            }

        }catch (SQLException e){
            System.out.println("Oops, Try again!");
            e.printStackTrace();
        }finally {
            try{
                if(connection != null && !connection.isClosed()) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return flag;
    }

    //********** Show All Student From Database **********//
    public static void showAllStudentFromDB(){
        Connection connection = CreateDB.createDBConnection();

        try{
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM STUDENTS";
            ResultSet set = statement.executeQuery(query);
            while (set.next()){
                System.out.println();
                System.out.println("ID: " + set.getInt(1));
                System.out.println("NAME: " + set.getString(2));
                System.out.println("PHONE: " + set.getString(3));
                System.out.println("EMAIL: " + set.getString(4));
                System.out.println("CITY: " + set.getString(5));

                for (int i = 0; i < 25; i++){
                    System.out.print("+");
                }
                System.out.println();
            }
        }catch (SQLException e){
            System.out.println("Oops, Try again!");
            e.printStackTrace();
        }finally {
            try{
                if(connection != null && !connection.isClosed()) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //******** Update Student In Database **********//
    public static boolean updateStudentInDB(int studentId, Student updatedStudent){
        Connection connection = CreateDB.createDBConnection();
        boolean flag = false;

        try{
            String query = "UPDATE STUDENTS SET SNAME=?, SPHONE=?, SEMAIL=?, SCITY=? WHERE SID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updatedStudent.getStudentName());
            preparedStatement.setString(2, updatedStudent.getStudentPhone());
            preparedStatement.setString(3, updatedStudent.getStudentEmail());
            preparedStatement.setString(4, updatedStudent.getStudentCity());
            preparedStatement.setInt(5, studentId);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0){
                flag = true;
            }
        }catch (SQLException e){
            System.out.println("Oops, Try again!");
            e.printStackTrace();
        }finally {
            try{
                if(connection != null && !connection.isClosed()) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return flag;
    }
}
