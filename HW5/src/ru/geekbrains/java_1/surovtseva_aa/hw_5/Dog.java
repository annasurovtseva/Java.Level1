package ru.geekbrains.java_1.surovtseva_aa.hw_5;

public class Dog extends Animal {

    Dog (String name) {
        super(name);
        type = "Пёсик";
        maxRun = (int)(Math.random()*201)+400;
        maxSwim = (int)(Math.random()*7)+7;
        maxJump = Math.random()+0.5;
    }
}
