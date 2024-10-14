// Superclass
class Vehicle55 {
    void move() {
        System.out.println("Vehicle moves");
    }
}

// Intermediate class inheriting from Animal
class Car55 extends Vehicle55 {
    void wheels() {
        System.out.println("I have 4 wheels");
    }
}

// Subclass inheriting from Mammal
class Convert55 extends Car55 {
    void retract() {
        System.out.println("My roof retracts");
    }
}

// Main class
public class Slinheritor {
    public static void main(String[] args) {
        Convert55 c1 = new Convert55();
        c1.move();    // Method from Super
        c1.wheels(); // Method from Inter
        c1.retract();   // Method from Base
    }
}

/*class Car55 {
    void sound() {
        System.out.println("Car makes sound");
    }
}

class Petrol extends Car55 {
    @Override
    void sound() {
        System.out.println("Car makes vroom vroom");
    }
}

class Electric extends Car55 {
    @Override
    void sound() {
        System.out.println("Car makes buzzz");
    }
}

public class slinheritor {

    public static void main(String[] args) {

        System.out.println("\nOverriding Example:");
        Car55 c1 = new Petrol();  // Correct way to instantiate Petrol
        Car55 c2 = new Electric(); // Correct way to instantiate Electric

        c1.sound();  // Outputs: Car makes vroom vroom
        c2.sound();  // Outputs: Car makes buzzz
    }
}
 */