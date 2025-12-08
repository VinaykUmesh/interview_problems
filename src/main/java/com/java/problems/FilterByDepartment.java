package com.java.problems;


import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Students {
    int id;
    String name;
    String dept;

    public Students(String name, String dept, int id) {
        this.name = name;
        this.dept = dept;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }
}

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

public class FilterByDepartment {

    public static void main(String[] args) {
        List<Students> students = new ArrayList<>();
        int count = 0;
        students.add(new Students("Umesh", "CSE", count++));
        students.add(new Students("Rajesh", "CSE", count++));
        students.add(new Students("Ramesh", "ECE", count++));
        students.add(new Students("Rakesh", "CSE", count++));
        students.add(new Students("Romesh", "MECH", count++));
        students.add(new Students("Uma", "MECH", count++));
        students.add(new Students("Uthra", "MECH", count++));
        students.add(new Students("Satish", "ECE", count++));
        students.add(new Students("Praveen", "CSE", count++));
        students.add(new Students("Siva", "CSE", count++));
        students.add(new Students("Saravanan", "MECH", count++));
        students.add(new Students("Suresh", "CSE", count));

        Map<String, List<String>> filtered = students.stream()
                .filter(student -> student.getDept().equals("CSE") || student.getDept().equals("MECH"))
                .collect(
                        Collectors.groupingBy(Students::getDept,
                                Collectors.mapping(Students::getName, Collectors.toList())));

        System.out.println(filtered);

        System.out.println(students.stream().map(Students::getId)
                .filter(id -> id % 2 == 0).collect(Collectors.toList()));


        System.out.println(students.stream().map(Students::getId).sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList()));
        System.out.println(students.stream().map(Students::getId).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));
        System.out.println(students.stream().map(Students::getId).sorted(Comparator.naturalOrder()).skip(3).limit(1).collect(Collectors.toList()));
        System.out.println(students.stream().map(Students::getId).sorted(Comparator.reverseOrder()).skip(4).limit(1).collect(Collectors.toList()));

        System.out.println(students.stream().collect(Collectors.groupingBy(Students::getDept, Collectors.counting())));
        Map<String, List<String>> ab = students.stream().
                collect(Collectors.groupingBy(Students::getDept, Collectors.mapping(Students::getName, Collectors.toList())));
        System.out.println(ab);

        System.out.println(students.stream().map(Students::getDept).distinct().collect(Collectors.toList()));
        System.out.println(students.stream().map(Students::getId).max(Comparator.naturalOrder()).get());
        System.out.println(students.stream().map(Students::getId).min(Comparator.naturalOrder()).get());


        int[] a = {10, 20, 30, 12, 10, 1, 2, 2, 45, 23};
        int[] b = {19, 29, 39, 13, 13, 3, 4, 4, 46, 24};

        System.out.println(Arrays.toString(IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray()));
        System.out.println(Arrays.toString(IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().boxed().sorted(Comparator.reverseOrder()).toArray()));

        System.out.println(Arrays.stream(a).sum());

        System.out.println((Integer) Stream.of(String.valueOf(123).split("")).mapToInt(Integer::parseInt).sum());
        List<String> list = Arrays.asList("eswaran", "Uma", "umesh", "mahesh", "is");
        System.out.println(list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.joining()));


        List<Integer> aa = Arrays.asList(10, 10, 9, 17, 16, 15, 11, 12, 12);
        List<Integer> bb = Arrays.asList(10, 9, 11, 13, 14);

        System.out.println(aa.stream().filter(bb::contains).collect(Collectors.toList()));

        System.out.println(Arrays.stream(a).sum());
        System.out.println(Arrays.stream(b).average().getAsDouble());

        String str = "Process finished with exit code";

        System.out.println(Stream.of(str.split(" ")).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" ")));

        System.out.println(Arrays.toString(IntStream.rangeClosed(1, b.length).map(i -> b[b.length - i]).toArray()));

        List<String> names = Arrays.asList("2umesh", "3makesh", "rajesh", "ram", "romesh", "5rupesh");

        System.out.println(names.stream().filter(i -> Character.isDigit(i.charAt(0))).collect(Collectors.toList()));

        System.out.println(IntStream.rangeClosed(1, 100).sum());

        String pal = "level";

        System.out.println(IntStream.range(0, pal.length() / 2).noneMatch(i -> pal.charAt(i) != pal.charAt(pal.length() - i - 1)));

        System.out.println(Arrays.stream(a).skip(a.length-1).findFirst());
        System.out.println(names.stream().skip(names.size() - 1).findFirst().get());

        Set<Integer> set = new HashSet<>();

        System.out.println(aa.stream().filter(i -> !set.add(i)).collect(Collectors.toSet()));

        System.out.println(Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10).map(f -> f[0]).collect(Collectors.toList()));



        // Get Highest salary and build result in type: Map<String, Employee>
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "umesh", "CSE", 30000));
        employees.add(new Employee(2, "mahesh", "MECH", 40000));
        employees.add(new Employee(3, "suresh", "CSE", 50000));
        employees.add(new Employee(4, "ramesh", "AERO", 30000));
        employees.add(new Employee(5, "vignesh", "CSE", 20000));
        employees.add(new Employee(6, "ganesh", "AERO", 15000));
        employees.add(new Employee(7, "karthi", "MECH", 24000));
        employees.add(new Employee(8, "mani", "CIVIL", 23000));
        employees.add(new Employee(9, "kiran", "CIVIL", 18000));

        Optional<Employee> maxSal = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));

        Map<String, Employee> employeeMap = maxSal
                .map(employee -> Collections.singletonMap(employee.department, employee))
                .orElse(Collections.emptyMap());

        employeeMap.forEach((key, value) -> System.out.println(key + " " + value.getName()));

//        1. Sort map2 (salary map) in reverse order of salary
//        2. Use the key from map1 (ID) by matching the name
//        Output should be:
//              ID – Name – Salary (in descending salary order)

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(101, "Rahul");
        map1.put(103, "Raj");
        map1.put(106, "Chinna");
        map1.put(105, "Rahim");
        Map<String, Double> map2 = new HashMap<>();
        map2.put("Chinna", 50000.0);
        map2.put("Rahim", 60000.0);
        map2.put("Raj", 70000.0);
        map2.put("Rahul", 20000.0);

        map2.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(afterSorted -> {
                    String name = afterSorted.getKey();
                    Double salary = afterSorted.getValue();

                    Integer id = map1.entrySet().stream()
                            .filter(x -> x.getValue().equals(name))
                            .map(Map.Entry::getKey)
                            .findFirst()
                            .orElse(null);
                    System.out.println(id + " - " + name + " - " + salary);
                });

    }

}
