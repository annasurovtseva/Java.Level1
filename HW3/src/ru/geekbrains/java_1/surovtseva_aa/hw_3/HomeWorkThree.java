package ru.geekbrains.java_1.surovtseva_aa.hw_3;

    import java.util.Scanner;
    import java.util.Random;

public class HomeWorkThree {
    private static final char signEmpty = '-';
    private static final char signHuman = 'X';
    private static final char signComp = '0';
    private static char[][] field;
    private static int size;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();


    // initField
    private static void initField () {
        size =3;
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j]=signEmpty;
            }
        }
    }

    //print field
    private static void printField () {
        System.out.print(" ");
        for (int i = 0; i < size * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < size; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= size * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    //Human Turn
    private static void humanTurn () {
        int x, y;
        do {
            System.out.print("Введите координаты хода Х и Y (от 1 до " + size + ") через пробел >>>");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCell(x,y) || !isEmptyCell(x,y));
        field[y][x] = signHuman;
    }


    //Valid Cell
    private static boolean isValidCell (int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    // Empty Cell
    private static boolean isEmptyCell (int x, int y) {
        return field[y][x] == signEmpty;
    }

    // Comp Turn
    private static void compTurn() {
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isEmptyCell(x,y));
        field[y][x] = signComp;
    }

    //!!! Задание 4 Компьютер блокирует человека
    private static void compTurn2() {
      int x = 0, y = 0;
      boolean humanWin = false;

      for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
              if (isEmptyCell(i, j)) {
                  field[j][i] = signHuman;
                  if (checkWin2(signHuman)) {
                      humanWin = true;
                      x = i;
                      y = j;
                    } field[j][i] = signEmpty;
               }
          }
      }

      if (!humanWin){
          do {
              x = random.nextInt(size);
              y = random.nextInt(size);
          } while (!isEmptyCell(x,y));
      }
        field[y][x] = signComp;
    }

    // Check Draw
    private static boolean checkDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == signEmpty){
                    return false;
                }
            }
        }
    return true;
    }

    // Check Win
    private static boolean checkWin(char c) {
        // hor
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }

    //!!! Задание 2 Проверка победы с использованием циклов
    private static boolean checkWin2 (char sign) {
        int hor, ver, diag1, diag2;
        for (int i = 0; i < size; i++) {
            hor = 0; ver = 0;
            for (int j = 0; j < size; j++) {
                if (field[i][j] == sign) {
                    hor++;
                }
                if (field[j][i] == sign) {
                    ver++;
                }
            }
            if (hor == size|| ver == size) return true;
        }
        diag1 = 0; diag2 = 0;
        for (int i = 0; i < size; i++) {
            if (field[i][i] == sign) {
                diag1++;
            }
            if (field[i][size - 1 - i] == sign) {
                diag2++;
            }
        }
        if (diag1 == size || diag2 == size) return true;
        return false;
    }

    //!!! Задание 3 Проверка победы для поля 5 Х 5 и 4 фишек
    // **Для проверки работы метода (size =5, gameChecks: checkWin2 -> checkWin3,
    // compTurn2: checkWin2 -> checkWin3)**
    private static boolean checkWin3 (char sign) {
        int hor, ver, diag1, diag2;
        for (int i = 0; i < size; i++) {
            hor = 0; ver = 0;
            for (int j = 0; j < size; j++) {
                if (hor != (size - 1) && field[i][j] != sign) hor = 0;
                if (ver != (size - 1) && field [j][i] != sign) ver = 0;
                if (field[i][j] == sign) {
                    hor++;
                }
                if (field[j][i] == sign) {
                    ver++;
                }
            }
            if (hor == size - 1 || ver == size - 1) return true;
        }
        diag1 = 0; diag2 = 0;
        for (int i = 0; i < size; i++) {
            if (diag1 != (size - 1) && field[i][i] != sign) diag1 = 0;
            if (diag2 != (size -1) && field[i][size-1-i] != sign) diag2 = 0;
            if (field[i][i] == sign) {
                diag1++;
            }
            if (field[i][size - 1 - i] == sign) {
                diag2++;
            }
        }
        if (diag1 == size-1 || diag2 == size-1) return true;
        return false;
    }

    // Game Checks
    private static boolean gameChecks(char sign, String msg) {
        if (checkWin2(sign)) {
            System.out.println(msg);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        initField();
        printField();
        while (true){
            humanTurn();
            printField();
            if (gameChecks(signHuman, "Победил человек!"))
                break;
            compTurn2();
            printField();
            if (gameChecks(signComp, "Победил компьютер!"))
                break;
        }
    }
}
