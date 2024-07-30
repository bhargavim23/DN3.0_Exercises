package employeeManagementSystem;

import java.util.Scanner;

public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    private static Employee[] employees = new Employee[100]; 
    private static int employeeCount = 0;


    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }


    public static void addEmployee(int employeeId, String name, String position, double salary) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = new Employee(employeeId, name, position, salary);
            System.out.println("The employee with ID " + employeeId + " has been added.");
        } else {
            System.out.println("Employee array is full.Cannot add more employees.");
        }
        displayEmployees();
    }


    public static void deleteEmployee(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].employeeId == employeeId) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--employeeCount] = null;
                System.out.println("The employee with ID " + employeeId + " has been deleted.");
                displayEmployees();
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }


    public static void searchEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee != null && employee.employeeId == employeeId) {
                System.out.println("Employee found: " + employee);
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }


    public static void displayEmployees() {
        System.out.println("------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-10s |\n", "Employee ID", "Name", "Position", "Salary");
        System.out.println("------------------------------------------------------");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("| %-10d | %-20s | %-15s | %-10.2f |\n", employee.employeeId, employee.name, employee.position, employee.salary);
            }
        }
        System.out.println("------------------------------------------------------");
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int employeeId = sc.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.next();
                    System.out.print("Enter Employee Position: ");
                    String position = sc.next();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(employeeId, name, position, salary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();
                    searchEmployee(searchId);
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
