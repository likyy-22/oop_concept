import java.util.Scanner;

class Person {

    String name;
    int age;
    int weight;

    public Person(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    void move() {
        System.out.println(name + " is moving and is not disabled.");
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
    }
}

class Player extends Person {

    String position;
    int jersey;

    public Player(String name, int age, int weight, String position, int jersey) {
        super(name, age, weight);
        this.position = position;
        this.jersey = jersey;
    }

    void play() {
        System.out.println(name + " is playing soccer as a " + position + " wearing jersey number " + jersey);
    }

    int calculateFitness() {
        int fitness = (weight / age) * 10;
        return fitness;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Position: " + position);
        System.out.println("Jersey Number: " + jersey);
        System.out.println("Fitness Score: " + calculateFitness());
    }
}

class Assistant extends Person {

    String role;

    public Assistant(String name, int age, int weight, String role) {
        super(name, age, weight);
        this.role = role;
    }

    void assist() {
        System.out.println(name + " is working as a " + role);
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: " + role);
    }
}

public class Soccer {

    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);

        do {
            System.out.println("Welcome to Liverpool FC");
            System.out.println("1. Become a Player");
            System.out.println("2. Become an Assistant");
            System.out.println("3. Exit");

            int option = s1.nextInt();
            s1.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter Player's Name:");
                    String playerName = s1.nextLine();
                    System.out.println("Enter Player's Age:");
                    int playerAge = s1.nextInt();
                    System.out.println("Enter Player's Weight:");
                    int playerWeight = s1.nextInt();
                    s1.nextLine(); // Consume newline
                    System.out.println("Enter Player's Position:");
                    String playerPosition = s1.nextLine();
                    System.out.println("Enter Player's Jersey Number:");
                    int playerJersey = s1.nextInt();

                    Player p1 = new Player(playerName, playerAge, playerWeight, playerPosition, playerJersey);
                    p1.displayDetails();
                    p1.play();
                    p1.move();
                    break;

                case 2:
                    System.out.println("Enter Assistant's Name:");
                    String assistantName = s1.nextLine();
                    System.out.println("Enter Assistant's Age:");
                    int assistantAge = s1.nextInt();
                    System.out.println("Enter Assistant's Weight:");
                    int assistantWeight = s1.nextInt();
                    s1.nextLine(); // Consume newline
                    System.out.println("Enter Assistant's Role (e.g., Coach, Manager):");
                    String assistantRole = s1.nextLine();

                    Assistant assistant = new Assistant(assistantName, assistantAge, assistantWeight, assistantRole);
                    assistant.displayDetails();
                    assistant.assist();
                    assistant.move();
                    break;

                case 3:
                    System.out.println("Exiting ....");
                    s1.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        } while (true);
    }
}
