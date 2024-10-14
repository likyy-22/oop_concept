abstract class Vehicle {

    // Abstract method that must be implemented by subclasses
    abstract void move();
}

class Car extends Vehicle {

    // Implementing the abstract method
    @Override
    void move() {
        System.out.println("The car moves.");
    }
}

public class abs {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();  // Output: The car moves.
    }
}
