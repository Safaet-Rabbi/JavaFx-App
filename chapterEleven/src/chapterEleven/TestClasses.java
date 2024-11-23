package chapterEleven;

public class TestClasses {
    public static void main(String[] args) {
        Person person = new Person("Safaet Rabbi", "123 Main St", "555-1234", "johndoe@example.com");
        Student student = new Student("Jack", "456 Maple Rd", "555-5678", "alice@example.com", Student.FRESHMAN);
        Employee employee = new Employee("Nicholson", "789 Oak St", "555-9876", "bob@example.com", "Room 101", 50000, new MyDate(2020, 5, 15));
        Faculty faculty = new Faculty("Dr. Dominic", "101 University Ave", "555-1111", "drsmith@example.com", "Room 201", 75000, new MyDate(2018, 8, 20), "10AM - 4PM", "Professor");
        Staff staff = new Staff("Mr. Wilson", "202 College Rd", "555-2222", "mrjones@example.com", "Room 301", 40000, new MyDate(2019, 1, 30), "Lab Technician");

        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }
}

