public class encap {
    // Attributes of the class will be hidden
    // Can be accessed only through methods (getters & setters)

    private String make;
    private String model;
    private int year;

    // Constructor
    public encap(String make, String model, int year) {
        this.make = make; //reference to current object param and inst var
        this.model = model;
        this.year = year;
    }

    // Getter for make
    public String getMake() {
        return make;
    }
    // Setter for make
    public void setMake(String make) {
        this.make = make;
    }

    // Getter for model
    public String getModel() {
        return model;
    }
    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    // Getter for year
    public int getYear() {
        return year;
    }
    // Setter for year
    public void setYear(int year) {
        this.year = year;
    }

    public static void main(String[] args) {
        encap car = new encap("Toyota", "Camry", 2020);

        // Accessing the fields using getters
        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());

        // Modifying the fields using setters
        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear(2022);

        // Accessing the updated fields using getters
        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());
    }
}
