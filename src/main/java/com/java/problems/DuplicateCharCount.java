package com.java.problems;

public class DuplicateCharCount {

    public static void main(String[] args) {
        String str = "Hello world";
        str = str.toLowerCase().replace("\\s", "");
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

            if (count > 1)
                System.out.println(ch + ":" + count);
        }
    }

}
