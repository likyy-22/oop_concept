import java.util.ArrayList;
import java.util.Scanner;

abstract class Person {
    private String name;
    private int age;
    private int id;

    Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public abstract void getDetails();
}

class Student extends Person {
    private String grade;

    Student(String name, int age, int id, String grade) {
        super(name, age, id);
        this.grade = grade;
    }

    @Override
    public void getDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("ID: " + getId());
        System.out.println("Grade: " + grade);
    }
}

class Teacher extends Person {
    private String subject;

    Teacher(String name, int age, int id, String subject) {
        super(name, age, id);
        this.subject = subject;
    }

    @Override
    public void getDetails() {
        System.out.println("Teacher Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("ID: " + getId());
        System.out.println("Subject: " + subject);
    }
}

// Admin class extending Person
class Admin extends Person {
    private String department;

    Admin(String name, int age, int id, String department) {
        super(name, age, id);
        this.department = department;
    }

    @Override
    public void getDetails() {
        System.out.println("Admin Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("ID: " + getId());
        System.out.println("Department: " + department);
    }
}

// Main class that contains the menu and logic to add/display people
class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int choice;

        do {
            System.out.println("1. Add New Person (Student, Teacher, Admin)");
            System.out.println("2. Display All Person Details");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("1. Student  2. Teacher  3. Admin Staff");
                    int personType = scanner.nextInt();
                    scanner.nextLine(); 

                    if (personType == 1) {
                      
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Student Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Student Grade: ");
                        String grade = scanner.nextLine();
                        people.add(new Student(name, age, id, grade));

                    } 
                    
                    else if (personType == 2) {
                     
                        System.out.print("Enter Teacher Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Teacher Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Teacher ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Subject Taught: ");
                        String subject = scanner.nextLine();
                        people.add(new Teacher(name, age, id, subject));

                    } 
                    
                    else if (personType == 3) 
                    {
                       
                        System.out.print("Enter Admin Staff Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Admin Staff Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Admin Staff ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();
                        people.add(new Admin(name, age, id, department));

                    } else {
                        System.out.println("Invalid choice for person type.");
                    }
                    break;

                case 2:
                    // Display all persons
                    if (people.isEmpty()) {
                        System.out.println("No person data available. Add a person first.");
                    }
                    else {
                        for (Person p1 : people) {
                            p1.getDetails();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid input. Please enter a number from 1 to 3.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}
