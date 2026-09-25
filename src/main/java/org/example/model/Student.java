package org.example.model;

public class Student {
    private long studentId;
    private String studentName;
    private String studentPhone;
    private String studentEmail;
    private String studentCity;


    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }


    public Student(long studentId, String studentName, String studentPhone,String studentEmail, String studentCity){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.studentCity = studentCity;
    }


    public Student(String studentName, String studentPhone, String studentEmail, String studentCity){
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.studentCity = studentCity;
    }

    public Student() {
        super();
    }
    @Override
    public String toString(){
        return "Student [studentId=" + studentId
                + ", studentName=" + studentName
                + ", studentPhone=" + studentPhone
                + ", studentEmail=" + studentEmail
                + ", studentCity=" + studentCity + "]";
    }
}