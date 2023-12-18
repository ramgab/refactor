package org.example;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.performCalculation();
    }

    public void performCalculation() {
        double num1 = getNumberFromUser("Enter the first number: ");
        double num2 = getNumberFromUser("Enter the second number: ");
        String operation = getOperationFromUser();

        double result = 0;

        if (operation.equals("+")) {
            result = num1 + num2;
        } else if (operation.equals("-")) {
            result = num1 - num2;
        } else if (operation.equals("*")) {
            result = num1 * num2;
        } else if (operation.equals("/")) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("Error: Division by zero is not allowed.");
                return;
            }
        } else {
            System.out.println("Error: Invalid operation.");
            return;
        }

        System.out.println("Result: " + result);
    }

    private double getNumberFromUser(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Error: Please enter a valid number.");
            System.out.print(message);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private String getOperationFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the operation (+, -, *, /): ");
        String operation = scanner.next();
        while (!isValidOperation(operation)) {
            System.out.println("Error: Invalid operation. Please enter +, -, *, or /.");
            System.out.print("Enter the operation (+, -, *, /): ");
            operation = scanner.next();
        }
        return operation;
    }

    private boolean isValidOperation(String operation) {
        return operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/");
    }
}
