package com.java.problems;

public class ReverseString {
    public static void main(String[] args) {
        String s = "fellow";
        StringBuilder r = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            r.insert(0, ch);
        }
        System.out.println(r);
    }
}