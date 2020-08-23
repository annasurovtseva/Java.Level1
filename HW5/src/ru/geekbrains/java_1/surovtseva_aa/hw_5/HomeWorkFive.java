package ru.geekbrains.java_1.surovtseva_aa.hw_5;

public class HomeWorkFive {

    public static void main (String[] args) {

        Animal[] pets = new Animal[4];
        pets[0] = new Cat("Мурзик");
        pets[1] = new Cat("Пушок");
        pets[2] = new Dog("Шарик");
        pets[3] = new Dog("Дружок");

        for (int i = 0; i < pets.length; i++) {
            System.out.println(pets[i].getInfo());
        }

         System.out.println();
         for (int i = 0; i < pets.length; i++) {
            pets[i].run(210);
            pets[i].swim(8);
            pets[i].jump(1.3 );
            System.out.println();
        }

    }

}
