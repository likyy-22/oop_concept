class nesclassstat {  //nested class stat
    private String name;
    private int age;

    public nesclassstat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static class Addresss {
        private String street;
        private String city;

        public Addresss(String street, String city) {
            this.street = street;
            this.city = city;
        }

    }

    public static void main(String[] args) {
        //outer class not needed to create to use nest class
        Addresss addresss = new Addresss("123 Main St", "Anytown"); 
        System.out.println("street=" + addresss.street + ", city=" + addresss.city);
    }
}