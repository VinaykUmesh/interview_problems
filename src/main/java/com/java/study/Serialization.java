package com.java.study;

import java.io.*;

class Persons implements Serializable {
    private static final long serialVersionUid = 1l;
    int age;
    String name;
    transient String secret; // this field cannot be serialized.

    public Persons(int age, String secret, String name) {
        this.age = age;
        this.secret = secret;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}

public class Serialization {

    public static void main(String[] args) {
        // Serialization to convert java object to byte stream
        Persons persons = new Persons(20, "Bob", "Some Secret");
        try {
            FileOutputStream file = new FileOutputStream("Secret.ser");
            ObjectOutputStream obj = new ObjectOutputStream(file);
            obj.writeObject(persons);
            obj.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Deserialization to convert byte stream to java object
        try (FileInputStream file = new FileInputStream("Secret.ser");
             ObjectInputStream obj = new ObjectInputStream(file)) {
            Persons person = (Persons) obj.readObject();
            System.out.println(person.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
