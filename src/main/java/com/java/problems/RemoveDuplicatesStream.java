package com.java.problems;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicatesStream {
    public static void main(String[] args) {
        String str = "Aakkashhh";
        StringBuilder sb = new StringBuilder().append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            sb.append(str.charAt(i));
        }
        System.out.println(sb);

        String result = IntStream.range(0, str.length())
                .mapToObj(i -> str.toLowerCase().charAt(i))
                .filter(new Predicate<Character>() {
                    char prev = 0;

                    @Override
                    public boolean test(Character character) {
                        System.out.println(character + " " + prev);
                        if (character.equals(prev)) return false;
                        prev = character;
                        return true;
                    }
                })
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(result);
    }
}
