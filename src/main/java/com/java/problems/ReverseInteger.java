package com.java.problems;

public class ReverseInteger {

    public static void main(String[] args) {
        int n = 98765;
        reverseInteger(n);
    }

    private static void reverseInteger(int n) {
        int reverse = 0;
        while (n > 0){
            int digit = n % 10; // Get the last digit of the number
            reverse = reverse * 10 + digit; // Add the digit to the reversed number
            n /= 10; // Remove the last digit from the original number
        }
        System.out.println(reverse);
    }

}
