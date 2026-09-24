import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // -------------------------
        // Create Employees
        // -------------------------

        User u1 = new User(
                101,
                "Ramya",
                "BTM",
                "Electronic City"
        );

        User u2 = new User(
                102,
                "Priya",
                "HSR Layout",
                "Electronic City"
        );

        User u3 = new User(
                103,
                "Rahul",
                "Koramangala",
                "Electronic City"
        );

        // -------------------------
        // Add Employees to Cab
        // -------------------------

        List<User> passengers = new ArrayList<>();

        passengers.add(u1);
        passengers.add(u2);
        passengers.add(u3);

        // -------------------------
        // Create Driver
        // -------------------------

        Driver d1 = new Driver(
                201,
                "Arjun",
                "KA05AB1234"
        );

        // -------------------------
        // Create Trip
        // -------------------------

        Trip t1 = new Trip(
                301,
                passengers,
                d1
        );

        OTPService otpService = new OTPService();

        // -------------------------
        // Driver Details
        // -------------------------

        System.out.println();
        System.out.println("===== DRIVER DETAILS =====");

        d1.displayDriver();

        System.out.println();

        System.out.println(
                "Employees assigned to this cab: "
                        + passengers.size()
        );

        // -------------------------
        // Boarding Process
        // -------------------------

        while (true) {

            // Automatically stop when all
            // assigned employees are processed

            if (t1.getProcessedCount()
                    == passengers.size()) {

                System.out.println();
                System.out.println(
                        "===== BOARDING COMPLETED ====="
                );

                System.out.println(
                        "Employees processed: "
                                + t1.getProcessedCount()
                                + " / "
                                + passengers.size()
                );

                System.out.println(
                        "Employees verified: "
                                + t1.getVerifiedCount()
                                + " / "
                                + passengers.size()
                );

                System.out.println(
                        "Trip completed."
                );

                break;
            }

            // -------------------------
            // Driver Menu
            // -------------------------

            int choice;

            while (true) {

                System.out.println();
                System.out.println(
                        "1. Enter Employee ID"
                );

                System.out.println(
                        "2. Close Boarding"
                );

                System.out.print(
                        "Enter choice: "
                );

                choice = scanner.nextInt();

                if (choice == 1 || choice == 2) {
                    break;
                }

                System.out.println();
                System.out.println(
                        "Invalid choice. "
                                + "Please enter 1 or 2."
                );
            }

            // -------------------------
            // Close Boarding
            // -------------------------

            if (choice == 2) {

                System.out.println();
                System.out.println(
                        "===== BOARDING CLOSED ====="
                );

                System.out.println(
                        "Employees processed: "
                                + t1.getProcessedCount()
                                + " / "
                                + passengers.size()
                );

                System.out.println(
                        "Employees verified: "
                                + t1.getVerifiedCount()
                                + " / "
                                + passengers.size()
                );

                System.out.println(
                        "Trip completed."
                );

                break;
            }

            // -------------------------
            // Enter Employee ID
            // -------------------------

            System.out.println();

            System.out.print(
                    "Enter Employee ID: "
            );

            int enteredId = scanner.nextInt();

            User selectedUser = null;

            // -------------------------
            // Find Employee
            // -------------------------

            for (User user : passengers) {

                if (user.userId == enteredId) {

                    selectedUser = user;
                    break;
                }
            }

            // -------------------------
            // Invalid Employee ID
            // -------------------------

            if (selectedUser == null) {

                System.out.println();

                System.out.println(
                        "Employee ID not allocated "
                                + "to this cab."
                );

                // Invalid ID does NOT count
                continue;
            }

            // -------------------------
            // Already Processed
            // -------------------------

            if (t1.isEmployeeProcessed(
                    selectedUser.userId)) {

                System.out.println();

                if (t1.isEmployeeVerified(
                        selectedUser.userId)) {

                    System.out.println(
                            "Employee "
                                    + selectedUser.userId
                                    + " has already been verified."
                    );

                } else {

                    System.out.println(
                            "Employee "
                                    + selectedUser.userId
                                    + " verification is blocked."
                    );

                    System.out.println(
                            "No further OTP can be generated."
                    );
                }

                continue;
            }

            // -------------------------
            // Set Current Employee
            // -------------------------

            t1.currentEmployeeId =
                    selectedUser.userId;

            t1.attempts = 0;
            t1.otp = null;

            // -------------------------
            // Employee Found
            // -------------------------

            System.out.println();

            System.out.println(
                    "Employee Found: "
                            + selectedUser.name
            );

            System.out.println(
                    "Pickup: "
                            + selectedUser.pickup
            );

            System.out.println(
                    "Destination: "
                            + selectedUser.destination
            );

            // -------------------------
            // Generate OTP
            // -------------------------

            String generatedOTP =
                    otpService.generateOTP();

            t1.otp = generatedOTP;

            // Temporary testing
            System.out.println();

            System.out.println(
                    "Generated OTP: "
                            + generatedOTP
            );

            // -------------------------
            // OTP Verification
            // -------------------------

            boolean verified = false;

            while (!verified
                    && !t1.isEmployeeBlocked(
                    selectedUser.userId)) {

                System.out.println();

                System.out.print(
                        "Enter OTP: "
                );

                String enteredOTP =
                        scanner.next();

                verified =
                        otpService.verifyOTP(
                                t1,
                                enteredOTP
                        );
            }

            // -------------------------
            // Employee Blocked
            // -------------------------

            if (t1.isEmployeeBlocked(
                    selectedUser.userId)) {

                System.out.println();

                System.out.println(
                        "Employee "
                                + selectedUser.userId
                                + " has been marked as blocked."
                );

                System.out.println(
                        "Employees processed: "
                                + t1.getProcessedCount()
                                + " / "
                                + passengers.size()
                );

                continue;
            }

            // -------------------------
            // Successful Verification
            // -------------------------

            if (verified) {

                t1.markEmployeeVerified(
                        selectedUser.userId
                );

                System.out.println();

                System.out.println(
                        "Employees verified: "
                                + t1.getVerifiedCount()
                                + " / "
                                + passengers.size()
                );

                System.out.println(
                        "Employees processed: "
                                + t1.getProcessedCount()
                                + " / "
                                + passengers.size()
                );
            }
        }

        scanner.close();
    }
}