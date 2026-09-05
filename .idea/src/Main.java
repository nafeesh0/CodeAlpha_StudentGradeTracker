import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Highest Scoring Student");
            System.out.println("6. Lowest Scoring Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter Java marks: ");
                int javaMarks = sc.nextInt();

                System.out.print("Enter DBMS marks: ");
                int dbmsMarks = sc.nextInt();

                System.out.print("Enter Python marks: ");
                int pythonMarks = sc.nextInt();

                Student student = new Student(
                        name,
                        javaMarks,
                        dbmsMarks,
                        pythonMarks
                );

                students.add(student);

                System.out.println("Student added successfully!");

            } else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No students found.");
                } else {

                    for (Student student : students) {

                        System.out.println("\n--------------------");
                        System.out.println("Name: " + student.name);
                        System.out.println("Total: " + student.calculateTotal());
                        System.out.printf("Average: %.2f%n",
                                student.calculateAverage());
                        System.out.println("Grade: " +
                                student.calculateGrade());
                    }
                }

            } else if (choice == 3) {

                System.out.print("Enter student name to search: ");
                String searchName = sc.nextLine();

                boolean found = false;

                for (Student student : students) {

                    if (student.name.equalsIgnoreCase(searchName)) {

                        System.out.println("\n===== Student Found =====");
                        System.out.println("Name: " + student.name);
                        System.out.println("Total: " + student.calculateTotal());
                        System.out.printf("Average: %.2f%n",
                                student.calculateAverage());
                        System.out.println("Grade: " +
                                student.calculateGrade());

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }

            }else if (choice == 7) {

                System.out.println("Thank you!");
                break;
            }else if (choice == 5) {

                if (students.isEmpty()) {
                    System.out.println("No students found.");
                } else {

                    Student highest = students.get(0);

                    for (Student student : students) {
                        if (student.calculateAverage() > highest.calculateAverage()) {
                            highest = student;
                        }
                    }

                    System.out.println("\n===== Highest Scoring Student =====");
                    System.out.println("Name: " + highest.name);
                    System.out.printf("Average: %.2f%n", highest.calculateAverage());
                    System.out.println("Grade: " + highest.calculateGrade());
                }

            }else if (choice == 6) {

                if (students.isEmpty()) {
                    System.out.println("No students found.");
                } else {

                    Student lowest = students.get(0);

                    for (Student student : students) {
                        if (student.calculateAverage() < lowest.calculateAverage()) {
                            lowest = student;
                        }
                    }

                    System.out.println("\n===== Lowest Scoring Student =====");
                    System.out.println("Name: " + lowest.name);
                    System.out.printf("Average: %.2f%n", lowest.calculateAverage());
                    System.out.println("Grade: " + lowest.calculateGrade());
                }

            } else {
                System.out.println("Invalid choice!");
            }

        }

        sc.close();
    }
}