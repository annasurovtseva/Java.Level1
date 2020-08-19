package ru.geekbrains.java_1.surovtseva_aa.hw_4;

public class Worker {
    private String FIO;
    private int salary;
    private int age;
    private int id;

    private static int count;

    Worker (String FIO, int salary, int age) {
        count++;
        id = count;
        this.FIO = FIO;
        this.salary = salary;
        this.age = age;
    }

    String getFIO() {
        return FIO;
    }

    int getSalary(){
        return salary;
    }

    int getAge() {
        return age;
    }

    int getId() {
        return id;
    }

    String getInfo() {
        return String.format("FIO: %s, age: %d",
                getFIO(), getAge());
    }

    String getFullInfo() {
        return String.format("ID: %d, FIO: %s, age: %d, salary: %d",
                getId(), getFIO(), getAge(), getSalary());
    }

    void upSalary() {
        if (getAge() > 45)
            salary = getSalary() + 5000;
    }
}
