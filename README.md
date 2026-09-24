# Java-OTP-generation-and-verification-for-transport-system

## Table of Contents

- [Introduction](#introduction)
- [Code](#code)
- [Usage](#usage)
- [Result Snapshots](#result-snapshots)
- [Tools](#tools)

## Introduction

Welcome to my Java OTP Generation and Verification for Transport System project! This project is designed to provide a secure employee boarding verification process for company transportation using One-Time Password (OTP) authentication.

The system allows a driver to verify employees assigned to a particular cab before boarding. The driver enters the employee ID, and the system checks whether the employee is allocated to the cab. For a valid employee, an OTP is generated and used to authenticate the employee.

The system also handles incorrect OTP attempts, OTP regeneration, employee blocking after multiple failed attempts, duplicate verification, and boarding completion.

## Code

Check out the code of the project by clicking here!

## Usage

1. Open the project in a Java development environment such as Visual Studio Code or IntelliJ IDEA.

2. Compile the Java source files.

3. Run the `Main.java` file to start the application.

4. The system displays the driver details and the number of employees assigned to the cab.

5. Select **Enter Employee ID** from the driver menu.

6. Enter the employee ID. The system checks whether the employee is assigned to the cab.

7. If the employee is valid, the system displays the employee details and generates an OTP.

8. Enter the generated OTP to complete employee verification.

9. If an incorrect OTP is entered, the system allows another attempt and generates a new OTP.

10. After three incorrect OTP attempts, the employee's verification is blocked and no further OTP can be generated for that employee.

11. If an employee has already been successfully verified, the system prevents duplicate verification.

12. The driver can select **Close Boarding** at any time to complete the trip.

13. Boarding is also automatically completed when all assigned employees have reached a final state, either verified or blocked.

## Result Snapshots

The application provides a console-based interface for employee transport verification.

The system displays the driver details and the number of employees assigned to the cab before the boarding process begins. The driver can enter an employee ID to verify whether the employee is allocated to the cab. For a valid employee, the system displays the employee's name, pickup location, destination, and generated OTP.The system verifies the entered OTP and confirms successful authentication when the correct OTP is provided.

<img width="326" height="480" alt="image" src="https://github.com/user-attachments/assets/657be59b-7388-46cc-afc5-2ef3b38b0038" />




If an incorrect OTP is entered, the system displays the remaining attempts and generates a new OTP. After three incorrect attempts, the system blocks the employee's verification and prevents any further OTP from being generated for that employee.

<img width="421" height="582" alt="image" src="https://github.com/user-attachments/assets/c9cf0125-2745-40f0-ac19-a4c8c86e0683" />


The system also prevents an employee who has already been verified from being processed again.

<img width="436" height="179" alt="image" src="https://github.com/user-attachments/assets/541940aa-0fb5-4765-8bc3-c84e965209a8" />

If an employee does not show up for the trip, the driver can select “Close Boarding” to end the boarding process without verifying that employee. The employee is therefore treated as a no-show for that trip. Once all employees have been processed, the system displays the boarding completion status and the number of verified employees.

<img width="372" height="185" alt="image" src="https://github.com/user-attachments/assets/07f78cbd-60f6-441c-a52f-165104411fe3" />


## Tools

Java

Visual Studio Code

GitHub

## Thanks for Watching

Thank you for checking out my Java OTP Generation and Verification for Transport System project!

If you found this project useful or interesting, please consider giving it a star 🌟 on GitHub. Your support is greatly appreciated!
