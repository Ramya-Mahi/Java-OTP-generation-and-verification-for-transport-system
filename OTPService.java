class OTPService {

    String generateOTP() {

        int otp = (int) (Math.random() * 9000) + 1000;

        return String.valueOf(otp);
    }

    boolean verifyOTP(Trip trip, String enteredOTP) {

        if (trip.isEmployeeBlocked(trip.currentEmployeeId)) {

            System.out.println(
                    "Verification is blocked for this employee."
            );

            return false;
        }

        if (trip.otp.equals(enteredOTP)) {

            System.out.println(
                    "OTP Verified Successfully!"
            );

            return true;
        }

        trip.attempts++;

        System.out.println(
                "Incorrect OTP."
        );

        if (trip.attempts < 3) {

            System.out.println(
                    "Attempts remaining: "
                            + (3 - trip.attempts)
            );

            String newOTP = generateOTP();

            trip.otp = newOTP;

            // Temporary testing
            System.out.println(
                    "New OTP: " + newOTP
            );

        } else {

            trip.markEmployeeBlocked(
                    trip.currentEmployeeId
            );

            System.out.println(
                    "Maximum attempts reached."
            );

            System.out.println(
                    "Verification blocked for Employee "
                            + trip.currentEmployeeId
            );
        }

        return false;
    }
}