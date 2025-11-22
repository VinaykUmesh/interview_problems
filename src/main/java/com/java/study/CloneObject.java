package com.java.study;

class Department implements Cloneable {
    String name;

    public Department(String name) {
        this.name = name;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}

class User implements Cloneable {
    int id;
    String name;
    Department dept;

    public User(int id, String name, Department dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    protected Object clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.dept = (Department) dept.clone();
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept.name +
                '}';
    }
}

public class CloneObject {

    public static void main(String[] args) throws CloneNotSupportedException {

        Department dept = new Department("Physics");
        User user = new User(1, "Hari", dept);
        User user1 = (User) user.clone();

        dept.name = "Maths";
        System.out.println(user.toString());
        System.out.println(user1.toString());
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());


    }
}
