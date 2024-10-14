interface PetrolEngine {
    default void sound1() {     //default needed
        System.out.println("Car makes vroom vroom");
    }
}

interface ElectricEngine {
    default void sound2() {      //default needed
        System.out.println("Car makes buzzz");
    }
}

class HybridCar implements PetrolEngine, ElectricEngine 
{
    public void sound3() {
        sound1();  
        sound2();  
    }
}

public class mlpinherit {
    public static void main(String[] args) {
        HybridCar h1 = new HybridCar();
        h1.sound3();  // Calls the sound3 method in HybridCar
    }
}
