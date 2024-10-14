import java.util.ArrayList;
import java.util.Scanner;

// Abstract Class for Employee
abstract class Employee {
    private String name;
    private int id;
    private String department;

    // Constructor
    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    // Getter methods (Encapsulation)
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    // Abstract method for calculating salary (Abstraction)
    public abstract double calculateSalary();

    // Method to display details
    public void getDetails() {
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee ID: " + getId());
        System.out.println("Department: " + getDepartment());
        System.out.println("Calculated Salary: " + calculateSalary());
        System.out.println(); // Print a blank line for better readability
    }
}

// Subclass for Manager (Inheritance)
class Manager extends Employee {
    private double baseSalary;
    private double bonus;

    public Manager(String name, int id, String department, double baseSalary, double bonus) {
        super(name, id, department);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    // Overriding calculateSalary method (Polymorphism)
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

// Subclass for Developer (Inheritance)
class Developer extends Employee {
    private double baseSalary;
    private double overtimePay;

    public Developer(String name, int id, String department, double baseSalary, double overtimePay) {
        super(name, id, department);
        this.baseSalary = baseSalary;
        this.overtimePay = overtimePay;
    }

    // Overriding calculateSalary method (Polymorphism)
    @Override
    public double calculateSalary() {
        return baseSalary + overtimePay;
    }
}

// Subclass for Intern (Inheritance)
class Intern extends Employee {
    private double stipend;

    public Intern(String name, int id, String department, double stipend) {
        super(name, id, department);
        this.stipend = stipend;
    }

    // Overriding calculateSalary method (Polymorphism)
    @Override
    public double calculateSalary() {
        return stipend;
    }
}

// Main class: Menu-Driven Application
public class Empmgmt {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        ArrayList<Employee> fire = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("Employee Management System:");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Developer");
            System.out.println("3. Add Intern");
            System.out.println("4. Display Salary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = s1.nextInt();
            s1.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Manager Name: ");
                    String managerName = s1.nextLine();
                    System.out.print("Enter Manager ID: ");
                    int managerId = s1.nextInt();
                    s1.nextLine();  // Consume newline
                    System.out.print("Enter Manager Department: ");
                    String managerDepartment = s1.nextLine();
                    System.out.print("Enter Base Salary: ");
                    double managerBaseSalary = s1.nextDouble();
                    System.out.print("Enter Bonus: ");
                    double managerBonus = s1.nextDouble();
                    s1.nextLine();  // Consume newline
                    fire.add(new Manager(managerName, managerId, managerDepartment, managerBaseSalary, managerBonus));
                    break;

                case 2:
                    System.out.print("Enter Developer Name: ");
                    String devName = s1.nextLine();
                    System.out.print("Enter Developer ID: ");
                    int devId = s1.nextInt();
                    s1.nextLine();  // Consume newline
                    System.out.print("Enter Developer Department: ");
                    String devDepartment = s1.nextLine();
                    System.out.print("Enter Base Salary: ");
                    double devBaseSalary = s1.nextDouble();
                    System.out.print("Enter Overtime Pay: ");
                    double devOvertimePay = s1.nextDouble();
                    s1.nextLine();  // Consume newline
                    fire.add(new Developer(devName, devId, devDepartment, devBaseSalary, devOvertimePay));
                    break;

                case 3:
                    System.out.print("Enter Intern Name: ");
                    String internName = s1.nextLine();
                    System.out.print("Enter Intern ID: ");
                    int internId = s1.nextInt();
                    s1.nextLine();  // Consume newline
                    System.out.print("Enter Intern Department: ");
                    String internDepartment = s1.nextLine();
                    System.out.print("Enter Stipend: ");
                    double stipend = s1.nextDouble();
                    s1.nextLine();  // Consume newline
                    fire.add(new Intern(internName, internId, internDepartment, stipend));
                    break;

                case 4:
                    if (fire.isEmpty()) {
                        System.out.println("No employee data available!");
                    } else {
                        for (Employee e1 : fire) {
                            e1.getDetails(); // Call the new method
                        }
                    }
                    break;

                case 5:
                    exit = true; // Exit the loop
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        }

        s1.close(); // Close the scanner
    }
}
