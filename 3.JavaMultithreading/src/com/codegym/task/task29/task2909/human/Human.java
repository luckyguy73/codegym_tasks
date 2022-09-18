package com.codegym.task.task29.task2909.human;

import java.util.*;

public class Human implements Alive {

    private static int nextId = 0;
    protected int age;
    protected String name;
    protected Size size;
    private final int id;
    private BloodType bloodType;
    private final List<Human> children = new ArrayList<>();

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId++;
        this.size = new Size();
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
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

    public List<Human> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.removeIf(c -> c.getId() == child.getId());
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Height: " + size.height + " Weight: " + size.weight);
    }

    public void live() { }

    public void printData() {
        System.out.printf("%s: %s%n", getPosition(), name);
    }

    public String getPosition() {
        return "Person";
    }

    public class Size {

        public int height;
        public int weight;

    }

}
