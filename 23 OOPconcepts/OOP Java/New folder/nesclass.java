class nesclass {  //nested class
    private String name;
    private int age;

    public nesclass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    class Address {
        private String street;
        private String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        public void display() {
            System.out.println(name + " lives at " + street + ", " + city+" yrs:"+age);
        }
    }

    public static void main(String[] args) {
        nesclass person = new nesclass("Alice", 30); //outer class needed to use inner class
        nesclass.Address address = person.new Address("123 Main St", "Anytown");
        address.display();
    }
}