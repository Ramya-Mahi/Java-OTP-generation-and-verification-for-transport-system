class User {

    int userId;
    String name;
    String pickup;
    String destination;

    User(int userId, String name, String pickup, String destination) {

        this.userId = userId;
        this.name = name;
        this.pickup = pickup;
        this.destination = destination;
    }

    void displayUser() {

        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Pickup: " + pickup);
        System.out.println("Destination: " + destination);
    }
}
