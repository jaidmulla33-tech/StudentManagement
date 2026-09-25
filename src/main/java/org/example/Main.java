package org.example;

import org.example.dao.StudentDAO;
import org.example.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to Student Management Application");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println();
            System.out.println("Press 1 to 'ADD'  new student.");
            System.out.println("Press 2 to 'DELETE'  given student.");
            System.out.println("Press 3 to 'UPDATE'  given student.");
            System.out.println("Press 4 to 'DISPLAY' all students.");
            System.out.println("Press 5 to EXIT.");
            System.out.println();
            int choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice){
                case 1:
                    System.out.println("Enter The Name of the Student.");
                    String name = bufferedReader.readLine();
                    System.out.println("Enter The Phone Number of the Student.");
                    String phone = bufferedReader.readLine();
                    System.out.println("Enter The Email Id of the Student.");
                    String email = bufferedReader.readLine();
                    System.out.println("Enter The City of residence of the Student.");
                    String city = bufferedReader.readLine();
                    Student student = new Student(name, phone, email, city);
                    System.out.println(StudentDAO.addStudentToDB(student)
                    ? "Student added successfully!" : "Something went wrong. Please Try Again!");
                    break;

                case 2:
                    System.out.println("Enter The 'ID' of the Student you would want to delete.");
                    int deleteId = Integer.parseInt(bufferedReader.readLine());
                    System.out.println(StudentDAO.deleteStudentFromDB(deleteId)
                    ? "Student deleted successfully!" : "Something went wrong. Please Try Again!");
                    break;

                case 3:
                    System.out.println("Enter The 'ID' of the student you would want to update.");
                    int updateId = Integer.parseInt(bufferedReader.readLine());
                    Student existing = StudentDAO.getStudentById(updateId);

                    if(existing != null){
                        System.out.println("Enter updated Name (blank to keep same): ");
                        String uName = bufferedReader.readLine();
                        System.out.println("Enter updated Phone (blank to keep same): ");
                        String uPhone = bufferedReader.readLine();
                        System.out.println("Enter updated Email (blank to keep same): ");
                        String uEmail = bufferedReader.readLine();
                        System.out.println("Enter updated City (blank to keep same): ");
                        String uCity = bufferedReader.readLine();

                        if(uName.isEmpty()) uName = existing.getStudentName();
                        if(uPhone.isEmpty()) uPhone = existing.getStudentPhone();
                        if(uEmail.isEmpty()) uEmail = existing.getStudentEmail();
                        if(uCity.isEmpty()) uCity = existing.getStudentCity();

                        Student updated = new Student(uName, uPhone, uEmail, uCity);
                        System.out.println(StudentDAO.updateStudentInDB(updateId, updated)
                        ? "Student updated successfully!" : "Something went wrong.");
                    }else{
                        System.out.println("No student found with ID: " + updateId);
                    }
                    break;

                case 4:
                    StudentDAO.showAllStudentFromDB();
                    break;

                case 5:
                    System.out.println("Existing....");
                    return;

                default:
                    System.out.println("Enter a valid option!");
            }
        }
    }
}