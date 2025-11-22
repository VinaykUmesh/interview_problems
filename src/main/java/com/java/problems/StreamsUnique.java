package com.java.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsUnique {

    public static void main(String[] args) {
        int[] arr = {11, 11, 12, 12, 13, 13, 14, 15, 16, 17, 20, 20};

        Map<Integer, Integer> unique = new HashMap<>();

        for (int i : arr) {
            unique.put(i, unique.getOrDefault(i, 0) + 1);
        }
        List<Integer> lint = new ArrayList<>();
        unique.forEach((k, v) -> {
            if (v == 1)
                lint.add(k);
        });
        System.out.println(lint);

        List<Integer> lint2 = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(lint2);

        Map<Integer, Long> mapL = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
