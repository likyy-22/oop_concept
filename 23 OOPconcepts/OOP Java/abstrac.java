abstract class Vehicle {
  // Abstract method (no body)
  abstract void startEngine();

  // Regular method
  void stopEngine() {
      System.out.println("The vehicle's engine is stopping.");
  }
}

class Car extends Vehicle {
  // Providing the implementation for the abstract method
  @Override
  void startEngine() {
      System.out.println("The car's engine is starting with a key.");
  }
}

// Main class
public class abstrac {
  public static void main(String[] args) {

      Vehicle c1 = new Car();
      c1.startEngine(); 
      c1.stopEngine();  
  }
}
