package ru.geekbrains.java_1.surovtseva_aa.hw_5;

public class Cat extends Animal {

    Cat (String name) {
        super(name);
        type = "Котик";
        maxRun = (int)(Math.random()*61)+170;
        maxJump = Math.random()*2+0.5;
    }

    @Override
    void swim (int distance) {
        System.out.println("Кошки не умеют плавать :(");
    }
}
