package ru.geekbrains.java_1.surovtseva_aa.hw_5;

    public abstract class Animal {
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    protected double maxJump;
    protected String type;

    Animal (String name) {
        this.name = name;
     }

    String getName(){
        return name;
    }
    String getType(){
        return type;
    }
    int getMaxRun () {
        return maxRun;
    }
    int getMaxSwim () {
        return maxSwim;
    }
    double getMaxJump() {
        return maxJump;
    }

    String getInfo() {
        return String.format("type: %s, name: %s, maxRun: %d, maxSwim: %d, maxJump: %.1f",
                getType(), getName(), getMaxRun(), getMaxSwim(), getMaxJump());
    }

    void run (int distance) {
        if (distance <= getMaxRun())
            System.out.println(type + " " + name + " пробежал " + distance + " м");
        else
            System.out.println(type + " " + name + " не смог пробежать расстояние " + distance + " м. Оно слишком большое для него");
    }

    void swim (int distance) {
        if (distance <= getMaxSwim())
            System.out.println(type + " " + name + " проплыл " + distance + " м");
        else
            System.out.println(type + " " + name + " не смог проплыть расстояние " + distance + " м. Оно слишком большое для него");
    }

    void jump (double distance) {
        if (distance <= getMaxJump())
            System.out.println(type + " " + name + " прыгнул на высоту " + distance + " м");
        else
            System.out.println(type + " " + name + " не смог прыгнуть. " + distance + " м слишком большая высота для него");
    }

}
