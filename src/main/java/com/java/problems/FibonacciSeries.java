package com.java.problems;

public class FibonacciSeries {

    public static void main(String[] args) {
        int count = 10;
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println(" ");
        fibonacciWithoutRecursion(count);
    }

    private static void fibonacciWithoutRecursion(int count) {
        int firstTerm = 0;
        int secondTerm = 1;

        if (count >= 1) {
            System.out.print(firstTerm + " ");
        }
        if (count >= 2) {
            System.out.print(secondTerm + " ");
        }

        for (int i = 3; i <= count; i++) {
            int nextTerm = firstTerm + secondTerm;
            System.out.print(nextTerm + " ");
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }

    private static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);

    }


}
