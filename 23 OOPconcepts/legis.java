import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class legis {
    private static List<Member> members = new ArrayList<>();
    private static List<Bill> bills = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();
    private static List<Constituency> constituencies = new ArrayList<>(); // To hold unique constituencies
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Goa Legislative Assembly Menu ---");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Add Bill");
            System.out.println("4. Create Session");
            System.out.println("5. See Sessions Created");
            System.out.println("6. View Constituencies");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    viewMembers();
                    break;
                case 3:
                    addBill();
                    break;
                case 4:
                    createSession();
                    break;
                case 5:
                    seeSessionsCreated();
                    break;
                case 6:
                    viewConstituencies();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addMember() {
        System.out.println("Choose member type:");
        System.out.println("1. MLA Member");
        System.out.println("2. Senior MLA Member");
        System.out.println("3. Special Member");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter constituency name: ");
        String constituencyName = scanner.nextLine();
        System.out.print("Enter party: ");
        String party = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
    
        // Create or retrieve constituency
        Constituency constituency = findOrCreateConstituency(constituencyName);
    
        Member newMember = null;
    
        switch (typeChoice) {
            case 1:
                newMember = new MLAMember(name, age, constituency.getName(), party, position);
                break;
            case 2:
                System.out.print("Enter years of service: ");
                int yearsOfService = scanner.nextInt();
                newMember = new SeniorMLAMember(name, age, constituency.getName(), party, position, yearsOfService);
                break;
            case 3:
                newMember = new SpecialMember(name, age, constituency.getName(), party, position);
                break;
            default:
                System.out.println("Invalid choice. Member not added.");
                return; // Exit the method if invalid choice
        }
    
        members.add(newMember);
        constituency.addMember(newMember); // Add member to the constituency
        System.out.println("Member added successfully.");
    }

    private static Constituency findOrCreateConstituency(String name) {
        for (Constituency constituency : constituencies) {
            if (constituency.getName().equalsIgnoreCase(name)) {
                return constituency; // Return existing constituency
            }
        }
        // If not found, create a new one
        Constituency newConstituency = new Constituency(name);
        constituencies.add(newConstituency);
        return newConstituency;
    }

    private static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
            return;
        }
        System.out.println("\n--- Members ---");
        for (Member member : members) {
            member.displayInfo();
            System.out.println();
        }
    }

    private static void addBill() {
        System.out.print("Enter bill title: ");
        String title = scanner.nextLine();
        System.out.print("Enter bill description: ");
        String description = scanner.nextLine();
        System.out.print("Enter proposer name: ");
        String proposer = scanner.nextLine();
        System.out.print("Enter date introduced: ");
        String dateIntroduced = scanner.nextLine();

        Bill newBill = new Bill(title, description, proposer, dateIntroduced, Bill.BillStatus.PROPOSED);
        bills.add(newBill);
        System.out.println("Bill added successfully.");
    }

    private static void createSession() {
        System.out.print("Enter session date (dd-mm-yyyy): ");
        String date = scanner.nextLine();
        System.out.print("Enter start hour (24-hour format): ");
        int startHour = scanner.nextInt();
        System.out.print("Enter start minute: ");
        int startMinute = scanner.nextInt();
        System.out.print("Enter end hour (24-hour format): ");
        int endHour = scanner.nextInt();
        System.out.print("Enter end minute: ");
        int endMinute = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter session agenda: ");
        String agenda = scanner.nextLine();

        Session newSession = new Session(date, startHour, startMinute, endHour, endMinute, agenda);
        sessions.add(newSession);
        System.out.println("Session created successfully.");
    }

    private static void seeSessionsCreated() {
        if (sessions.isEmpty()) {
            System.out.println("No sessions created.");
            return;
        }
        System.out.println("\n--- Sessions Created ---");
        for (Session session : sessions) {
            session.displayInfo();
            System.out.println();
        }
    }

    private static void viewConstituencies() {
        if (constituencies.isEmpty()) {
            System.out.println("No constituencies available.");
            return;
        }
        System.out.println("\n--- Constituencies ---");
        for (Constituency constituency : constituencies) {
            constituency.displayInfo();
            System.out.println();
        }
    }
}
