class Car { // Static nested class example
    private String model;

    static class Wheel {
        private int sizeInInches;

        public Wheel(int sizeInInches) {
            this.sizeInInches = sizeInInches;
        }

        public void rotate() {
            System.out.println("Wheel rotating...");
        }
    }

    public Car(String model) {
        this.model = model;
    }

    public static void main(String[] args) {
        Car.Wheel frontLeft = new Car.Wheel(18);
        Car.Wheel frontRight = new Car.Wheel(18);

        frontLeft.rotate();
        frontRight.rotate();
    }
}
