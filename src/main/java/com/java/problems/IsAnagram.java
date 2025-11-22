package com.java.problems;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsAnagram {

    private static String isAnagram(String a, String b) {

        String first = Stream.of(a.replaceAll("\\s", "").split(""))
                .sorted()
                .map(String::toLowerCase)
                .collect(Collectors.joining());

        String second = Stream.of(b.replaceAll("\\s", "").split(""))
                .sorted()
                .map(String::toLowerCase)
                .collect(Collectors.joining());

        return first.equals(second) ? "Are Anagrams" : "Are Not Anagrams";

    }

    public static void main(String[] args) {

        System.out.println(isAnagram("RatRace", "CatRace"));
        System.out.println(isAnagram("RaceCar", "CarRace"));

    }
}