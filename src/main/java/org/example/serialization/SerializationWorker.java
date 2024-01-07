package org.example.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationWorker {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Name", "Surname", 30, List.of("Task1", "Task2")));
        persons.add(new Person("name", "Surname", 25, List.of("Task3", "Task4")));

        serializeObject(persons, "persons.ser");

        List<Person> deserializedPersons = deserializeObject("persons.ser");
        deserializedPersons.forEach(System.out::println);
    }

    // სერიალიზაცია
    public static <T> void serializeObject(T obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // დესერიალიზაცია
    @SuppressWarnings("unchecked")
    public static <T> T deserializeObject(String fileName) {
        T obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            obj = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // Person კლასი
    static class Person implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        private String name;
        private String lastname;
        private int age;
        private List<String> tasks;

        public Person(String name, String lastname, int age, List<String> tasks) {
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.tasks = tasks;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', lastname='" + lastname + "', age=" + age + ", tasks=" + tasks + '}';
        }
    }
}
