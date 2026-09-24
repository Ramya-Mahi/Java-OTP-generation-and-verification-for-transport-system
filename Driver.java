class Driver {

    int driverId;
    String name;
    String cabNumber;

    Driver(int driverId, String name, String cabNumber) {

        this.driverId = driverId;
        this.name = name;
        this.cabNumber = cabNumber;
    }

    void displayDriver() {

        System.out.println("Driver ID: " + driverId);
        System.out.println("Driver Name: " + name);
        System.out.println("Cab Number: " + cabNumber);
    }
}