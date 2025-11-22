package com.java.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Students implements java.lang.Comparable<Students> {

    private int age;
    private String name;

    @Override
    public int compareTo(Students other) {
        return Integer.compare(this.age, other.age);
    }

    public Students(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Comparable {

    public static void main(String[] args) {
        List<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students(43, "umesh"));
        studentsList.add(new Students(45, "Ram"));
        studentsList.add(new Students(25, "rajesh"));
        Collections.sort(studentsList); // natural order sorting
        studentsList.forEach(System.out::println);


        List<Students> studentsList2 = new ArrayList<>();
        studentsList2.add(new Students(43, "abi"));
        studentsList2.add(new Students(45, "Ram"));
        studentsList2.add(new Students(25, "satish"));

        // custom sorting by age
        Comparator<Students> byAge = (s1, s2) -> Integer.compare(s2.getAge(), s1.getAge());
        studentsList2.sort(byAge);
        System.out.println(" ");
        studentsList2.forEach(System.out::println);

        // custom sorting by name
        Comparator<Students> byName = (s1, s2) -> s2.getName().compareTo(s1.getName());
        studentsList2.sort(byName);
        System.out.println(" ");
        studentsList2.forEach(System.out::println);

    }
}
