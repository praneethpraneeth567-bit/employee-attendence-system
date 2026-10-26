

import java.io.*;
import java.time.LocalDate;
import java.util.*;

class Employee {
    int id;
    String name;
    String email;

    Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

class Leave {
    int empId;
    String fromDate;
    String toDate;
    String reason;
    String status;

    Leave(int empId, String fromDate, String toDate, String reason, String status) {
        this.empId = empId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
    }
}

public class Main {
    static List<Employee> employees = new ArrayList<>();
    static List<String> attendance = new ArrayList<>();
    static List<Leave> leaves = new ArrayList<>();

    static int empIdCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Apply Leave");
            System.out.println("5. View Leaves");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> viewEmployees();
                case 3 -> markAttendance(sc);
                case 4 -> applyLeave(sc);
                case 5 -> viewLeaves();
                case 6 -> System.exit(0);
            }
        }
    }

    static void addEmployee(Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Employee emp = new Employee(empIdCounter++, name, email);
        employees.add(emp);

        System.out.println("Employee added!");
    }

    static void viewEmployees() {
        for (Employee e : employees) {
            System.out.println(e.id + " - " + e.name + " - " + e.email);
        }
    }

    static void markAttendance(Scanner sc) {
        System.out.print("Employee ID: ");
        int id = sc.nextInt();

        String record = "EmpID: " + id + " Date: " + LocalDate.now() + " Status: Present";
        attendance.add(record);

        System.out.println("Attendance marked!");
    }

    static void applyLeave(Scanner sc) {
        System.out.print("Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("From Date (YYYY-MM-DD): ");
        String from = sc.nextLine();
        System.out.print("To Date (YYYY-MM-DD): ");
        String to = sc.nextLine();
        System.out.print("Reason: ");
        String reason = sc.nextLine();

        Leave leave = new Leave(id, from, to, reason, "Pending");
        leaves.add(leave);

        System.out.println("Leave applied!");
    }

    static void viewLeaves() {
        for (Leave l : leaves) {
            System.out.println("EmpID: " + l.empId +
                    " | " + l.fromDate + " to " + l.toDate +
                    " | " + l.reason +
                    " | " + l.status);
        }
    }
}

/*
FEATURES:
- No SQL / No Database
- Uses ArrayList (memory-based)
- Simple and easy for mini project

OPTIONAL IMPROVEMENT:
- Save data into file using FileWriter
- Load data using FileReader
*/
