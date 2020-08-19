package ru.geekbrains.java_1.surovtseva_aa.hw_4;

public class HomeWorkFour {

    private static int getMiddleSalary (Worker[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getSalary();
        }
        return sum/arr.length;
    }

    private static int getMiddleAge (Worker[] arr) {
        int age = 0;
        for (int i = 0; i < arr.length; i++) {
            age += arr[i].getAge();
        }
        return age/arr.length;
    }

    public static void main (String[] args) {

        Worker[] staff = new Worker[5];
        staff[0] = new Worker("Petrov Petr", 42000,32);
        staff[1] = new Worker("Antonov Anton", 37000,47);
        staff[2] = new Worker("Semenov Semen", 50000,35);
        staff[3] = new Worker("Sergeev Sergey", 53000,50);
        staff[4] = new Worker("Romanov Roman", 40000,45);


        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 40)
            System.out.println(staff[i].getInfo());
         }

        System.out.println();
        for (int i = 0; i < staff.length; i++) {
            staff[i].upSalary();
            System.out.println(staff[i].getFullInfo());
        }

        System.out.println();
        System.out.println("Средняя зарплата равна: " + getMiddleSalary(staff) +
                "\nСредний возраст равен: " + getMiddleAge(staff));

    }
}
