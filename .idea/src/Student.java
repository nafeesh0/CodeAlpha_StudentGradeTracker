public class Student {

    String name;
    int javaMarks;
    int dbmsMarks;
    int pythonMarks;

    Student(String name, int javaMarks, int dbmsMarks, int pythonMarks) {
        this.name = name;
        this.javaMarks = javaMarks;
        this.dbmsMarks = dbmsMarks;
        this.pythonMarks = pythonMarks;
    }

    int calculateTotal() {
        return javaMarks + dbmsMarks + pythonMarks;
    }

    double calculateAverage() {
        return calculateTotal() / 3.0;
    }
    String calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}