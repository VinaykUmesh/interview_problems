package com.java.problems;

public class CharCount {

    public static void main(String[] args) {
        String str = "Hello World";
        str = str.toLowerCase().replaceAll("\\s", "");
        int len = str.length();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (str.indexOf(ch) != i)
                continue;


            int count = 0;
            for (int j = 0; j < len; j++) {
                if (ch == str.charAt(j))
                    count++;
            }
            System.out.println(ch + ":" + count);
        }
    }

}
