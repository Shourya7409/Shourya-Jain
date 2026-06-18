import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentMarks = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        int totalMarks = 0;
        int highestMarks = Integer.MIN_VALUE;
        int lowestMarks = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            studentNames.add(name);
            studentMarks.add(marks);

            totalMarks += marks;

            if (marks > highestMarks) {
                highestMarks = marks;
            }

            if (marks < lowestMarks) {
                lowestMarks = marks;
            }
        }

        double averageMarks = (double) totalMarks / n;

        System.out.println("\n===== STUDENT GRADE REPORT =====");

        for (int i = 0; i < n; i++) {
            System.out.println(studentNames.get(i) + " : " + studentMarks.get(i));
        }

        System.out.println("\nAverage Marks : " + averageMarks);
        System.out.println("Highest Marks : " + highestMarks);
        System.out.println("Lowest Marks  : " + lowestMarks);

        sc.close();
    }
}