package org.example.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Use {
    public static void main(String[] args) {
        // Single catch blocks
        try {
            int result = 10 / 0;
        } catch (ArithmeticException err) {
            System.err.println(err.getMessage());
        }

        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException err) {
            System.err.println(err.getMessage());
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("file.txt");
        } catch (FileNotFoundException err) {
            System.err.println(err.getMessage());
        }

        // Multiple catch blocks
        String s = "textWithNumber123";
        Integer[] numbers = new Integer[3];
        try {
            numbers[3] = 45;
            numbers[3] = Integer.parseInt(s);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (NumberFormatException e) {
            numbers[0] = Integer.parseInt((s).replaceAll("[\\D]", ""));
            System.err.println("NumberFormatException: " + e.getMessage());
        } catch (Exception e) {
            numbers[0] = 0;
            System.err.println("General Exception: " + e.getMessage());
        }

        // Finally block
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("example.txt");
            // Write data to the file
        } catch (IOException e) {
            // Handle file-related exception
        } finally {
            // Ensure the file stream is closed, even if an exception occurs
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    // Handle any exceptions that occur during the close operation
                }
            }
        }

        // Throwing exception
        try {
            int age = -5;
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }

        // How to create and use custom exception
        try {
            int test = 0;
            if (test == 0) {
                throw new CustomException("Variable test can't be zero.");
            }
        } catch (CustomException err) {
            System.err.println(err.getMessage());
        }

        // Use function which throws exception
        try {
            test();
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }
    }

    // Exception in function
    private static void test() throws CustomException {
        int number = 0;
        if (number == 0) {
            throw new CustomException("Variable test can't be zero.");
        }
    }
}
