// Interface template that can be applied to a class
// Similar to inheritance but specifies what a class has/must do
// Classes can apply more than one interface; inheritance is limited to one superclass
//only 1 class/interface can be public to work single file
interface Prey {
    void run();
}

interface Predator {
    void hunt();
}

class Rabbit implements Prey {
    @Override
    public void run() {
        System.out.println("The rabbit runs away");
    }
}

class Lion implements Predator {
    @Override
    public void hunt() {
        System.out.println("The Lion hunts the rabbit");
    }
}

class Fish implements Prey, Predator {
    @Override
    public void run() {
        System.out.println("The Fish runs away from big fish");
    }
    
    @Override
    public void hunt() {
        System.out.println("The Fish hunts small fish");
    }
}

// Main class
public class interf {
    public static void main(String[] args) {
        Rabbit r1 = new Rabbit();
        r1.run();  
        Lion l1 = new Lion();
        l1.hunt();
        Fish f1 = new Fish();
        f1.run();
        f1.hunt();
    }
}

