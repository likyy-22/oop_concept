class Person {
    String name;
    int age;

    // Default
    public Person() {
        this.name = "Clayton";
        this.age = 21;
        System.out.println("Default constructor called");
    }

    //Parameterized 
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor called");
    }

    // Copy
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        System.out.println("Copy constructor called");
    }

    // Method to display person details
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        
        Person p1 = new Person();
        p1.display();

        Person p2 = new Person("CRS", 25);
        p2.display();

        Person p3 = new Person(p2);
        p3.display();
    }
}
