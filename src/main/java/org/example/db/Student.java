package org.example.db;

public class Student {
    // Properties
    private long id;
    private String name;
    private int age;

    // Constructors
    public Student() {  }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}