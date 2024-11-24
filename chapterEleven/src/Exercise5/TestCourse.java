package Exercise5;

public class TestCourse {
    public static void main(String[] args) {
        Course course = new Course("Introduction to Java");

        // Add students
        course.addStudent("Safaet");
        course.addStudent("Michael");
        course.addStudent("Elliot");

        // Display course information
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Number of Students: " + course.getNumberOfStudents());

        // Display students
        String[] students = course.getStudents();
        for (String student : students) {
            System.out.println("Student: " + student);
        }

        // Drop a student and display updated information
        course.dropStudent("Michael");
        System.out.println("\nAfter dropping Bob:");
        System.out.println("Number of Students: " + course.getNumberOfStudents());
        students = course.getStudents();
        for (String student : students) {
            System.out.println("Student: " + student);
        }
    }
}
