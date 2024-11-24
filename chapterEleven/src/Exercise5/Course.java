package Exercise5;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<String> students;
    private int numberOfStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
        numberOfStudents = 0;
    }

    // Method to add a student to the course
    public void addStudent(String student) {
        students.add(student);
        numberOfStudents++;
    }

    // Method to drop a student from the course
    public void dropStudent(String student) {
        if (students.remove(student)) {
            numberOfStudents--;
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to return an array of students
    public String[] getStudents() {
        return students.toArray(new String[0]);
    }

    // Method to get the course name
    public String getCourseName() {
        return courseName;
    }

    // Method to get the number of students
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}
