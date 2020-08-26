package ru.geekbrains.java_1.surovtseva_aa.hw_6;

    import java.io.*;
    import java.util.Scanner;

public class HomeWorkSix {

    private static void createFile (String fileName, String text) throws IOException {
        PrintStream ps = new PrintStream(new FileOutputStream(fileName));
        ps.println(text);
        ps.flush();
        ps.close();
    }

    // Копируем по байтам
    private static void glueFiles1 (String[] files, String distFile) throws IOException {

        FileOutputStream fos = new FileOutputStream(distFile, true);
        for (int i = 0; i < files.length; i++) {
            FileInputStream fis = new FileInputStream(files[i]);
            int sign;
            while ((sign = fis.read()) != -1) {
                fos.write(sign);
            }
            fis.close();
        }
        fos.flush();
        fos.close();
    }

    //Копируем по строкам
    private static void glueFiles2 (String[] files, String distFile) throws IOException {

        PrintStream ps = new PrintStream(new FileOutputStream(distFile, true));

        for (int i = 0; i < files.length; i++) {
            Scanner scan = new Scanner(new FileInputStream(files[i]));
            while (scan.hasNextLine()) {
                ps.append(scan.nextLine());
                ps.append("\n");
            }
            scan.close();
        }
        ps.flush();
        ps.close();
    }

    //Ищем в файле по байтам
    private static boolean searchWord1 (String fileName, String word) throws IOException {

        FileInputStream fis = new FileInputStream(fileName);
        int sign;
        int i = 0;
        byte[] wordByte = word.getBytes();
        while ((sign = fis.read()) != -1){
            if (wordByte[i] == sign){
                i++;
                if (i == wordByte.length)
                    return true;
            } else {
                i = 0;
            }
        }
        fis.close();
        return false;
    }

    //Ищем в файле посимвольно, игнорируя регистр
    private static boolean searchWord2 (String fileName, String word) throws IOException {
        Scanner scan = new Scanner(new FileInputStream(fileName));
        int i = 0;
        char[] wordChar = word.toCharArray();
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            char[] str = s.toCharArray();
            for (int j = 0; j < str.length; j++) {
                if (Character.toLowerCase(str[j]) == Character.toLowerCase(wordChar[i])){
                    i++;
                    if (i == wordChar.length)
                        return true;
                } else {
                    i = 0;
                }
            }
        }
        scan.close();
        return false;
    }

    // Ищем в папке совпадение с заданным набором символов
    private static boolean searchWordInCatalog(String word, String pathDir) throws IOException {

        File dir = new File(pathDir);
        File[] cat = dir.listFiles();
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].isFile()) {
                String fileName = cat[i].toString();
                if (searchWord2(fileName,word))
                    return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {

        String s1 = "He had successfully avoided meeting his landlady on the staircase.";
        String s2 = "His garret was under the roof of a high, five-storied house and was more " +
                "like a cupboard than a room.";

        try {
            createFile("text1.txt",s1);
            createFile("text2.txt", s2);
            glueFiles1(new String[]{"text1.txt","text2.txt"}, "text3.txt");
            glueFiles2(new String[]{"text1.txt","text2.txt"}, "text4.txt");
            System.out.println(searchWord1("text3.txt", "garr"));
            System.out.println();
            System.out.println(searchWord2("text3.txt", "roOm"));
            System.out.println();
            System.out.println(searchWordInCatalog("Denmark","./"));
          } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
