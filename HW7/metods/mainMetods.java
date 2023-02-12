package metods;

import java.util.Scanner;
import java.util.Random;

public class mainMetods {
    static Scanner str = new Scanner(System.in);

    public static void findSymbolOccurance() {
        int count = 0;
        System.out.println("Запускаем метод findSymbolOccurance()");
        System.out.println("Введите строку по которой будет происодить поиск буквы");
        String line = str.nextLine();
        System.out.println("Введите символ по которому будем искать");
        String a = str.nextLine();
        int index = line.indexOf(a);
        while (index != -1) {
            index = line.indexOf(a, index + 1);
            count = count + 1;

        }
        System.out.println("Кол-во повторений символа: " + count);
    }

    public static void findWordPosition() {
        int minIndex = 0;
        System.out.println("Запускаем метод findWordPosition()");
        System.out.println("Введите строку по которой будем искать подстроку ");
        String source = str.nextLine();
        System.out.println("Введите подстроку по которому будем искать");
        String target = str.nextLine();
        int index = source.indexOf(target);
        System.out.println("Результат: " + index);
    }

    public static void stringReverse() {
        System.out.println("Запускаем метод stringReverse()");
        System.out.println("Введите строку, которую будем разворачивать");
        String line = str.nextLine();
        StringBuilder sb = new StringBuilder(line);
        StringBuilder reverLine = new StringBuilder(sb.reverse().toString());
        System.out.println("Реверс получился такой: " + line + "->" + reverLine);
    }

    public static void isPalindrome() {
        System.out.println("Запускаем метод isPalindrome()");
        System.out.println("Введите строку, которую будем проверять на полидром");
        String line = str.nextLine();

        StringBuffer rev = new StringBuffer(line).reverse();

        String strRev = rev.toString();

        if (line.equalsIgnoreCase(strRev)) {
            System.out.println("Слово полидром");
        } else {
            System.out.println("Слово НЕполидром");
        }
    }

    public static void isGameRandom() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                 "avocado" , "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                 "leak", "kiwi", "mango","mushroom", "nut", "olive", " pea", "peanut",
                 "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random r = new Random();
        int x = r.nextInt(words.length - 1);
        String secretWords = "###############";
        String namedWordsWhoSecret = words[x];
        System.out.println("Я загадал слово, тебе нужно его отгадать. Вводи слово");


        String lineAnswer;
        do {
             lineAnswer = str.nextLine();

            for (int i = 0; i < lineAnswer.length(); i++) {
                if (lineAnswer.charAt(i) == namedWordsWhoSecret.charAt(i)) {
                    char letter = lineAnswer.charAt(i);
                    StringBuilder sb = new StringBuilder(secretWords);
                    sb.setCharAt(i, letter);
                    secretWords = sb.toString();
                }
            }

             if (lineAnswer.equals(namedWordsWhoSecret) ){
                 break;
             } else{
                 System.out.println(secretWords);
                 System.out.println("Давай отгадаем слово. Жду новое слово");
             }

        } while (lineAnswer != namedWordsWhoSecret);
        System.out.println("Успех!");

    }

}