import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Trip {

    int tripId;
    List<User> users;
    Driver driver;

    Set<Integer> verifiedEmployees;
    Set<Integer> blockedEmployees;
    Set<Integer> processedEmployees;

    String otp;
    int attempts;
    int currentEmployeeId;

    Trip(int tripId, List<User> users, Driver driver) {

        this.tripId = tripId;
        this.users = users;
        this.driver = driver;

        verifiedEmployees = new HashSet<>();
        blockedEmployees = new HashSet<>();
        processedEmployees = new HashSet<>();

        otp = null;
        attempts = 0;
        currentEmployeeId = 0;
    }

    boolean isEmployeeVerified(int userId) {
        return verifiedEmployees.contains(userId);
    }

    void markEmployeeVerified(int userId) {
        verifiedEmployees.add(userId);
        processedEmployees.add(userId);
    }

    boolean isEmployeeBlocked(int userId) {
        return blockedEmployees.contains(userId);
    }

    void markEmployeeBlocked(int userId) {
        blockedEmployees.add(userId);
        processedEmployees.add(userId);
    }

    boolean isEmployeeProcessed(int userId) {
        return processedEmployees.contains(userId);
    }

    int getVerifiedCount() {
        return verifiedEmployees.size();
    }

    int getProcessedCount() {
        return processedEmployees.size();
    }

    void resetVerification() {
        otp = null;
        attempts = 0;
        currentEmployeeId = 0;
    }

    void displayTrip() {

        System.out.println("Trip ID: " + tripId);

        for (User user : users) {
            System.out.println("User: " + user.name);
        }

        System.out.println("Driver: " + driver.name);

        System.out.println(
                "Employees Verified: "
                        + verifiedEmployees.size()
                        + " / "
                        + users.size()
        );
    }
}
