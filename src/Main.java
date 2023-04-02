import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> arabicNums = new HashMap<>();
        arabicNums.put("1", 1);
        arabicNums.put("2", 2);
        arabicNums.put("3", 3);
        arabicNums.put("4", 4);
        arabicNums.put("5", 5);
        arabicNums.put("6", 6);
        arabicNums.put("7", 7);
        arabicNums.put("8", 8);
        arabicNums.put("9", 9);
        arabicNums.put("10", 10);

        HashMap<String, Integer> romanNums = new HashMap<>();
        romanNums.put("I", 1);
        romanNums.put("II", 2);
        romanNums.put("III", 3);
        romanNums.put("IV", 4);
        romanNums.put("V", 5);
        romanNums.put("VI", 6);
        romanNums.put("VII", 7);
        romanNums.put("VIII", 8);
        romanNums.put("IX", 9);
        romanNums.put("X", 10);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите значение:");
            String text = scanner.nextLine();
            text = text.trim();
            String[] arrOfElem = text.split("\\s+");

            if (arrOfElem.length < 3) {
                throw new IOException("Вывод ошибки, так как строка не является математической операцией.");
            } else if (arrOfElem.length > 3) {
                throw new IOException("Вывод ошибки, так как формат математической операции не удовлетворяет " +
                        "заданию — два операнда и один оператор (+, -, /, *).");
            } else {
                String num1 = arrOfElem[0];
                String num2 = arrOfElem[2];
                String operator = arrOfElem[1];
                if (arabicNums.containsKey(num1) && arabicNums.containsKey(num2)) {
                    switch (operator) {
                        case "+":
                            System.out.println(arabicNums.get(num1) + arabicNums.get(num2));
                            break;
                        case "-":
                            System.out.println(arabicNums.get(num1) - arabicNums.get(num2));
                            break;
                        case "*":
                            System.out.println(arabicNums.get(num1) * arabicNums.get(num2));
                            break;
                        case "/":
                            System.out.println(arabicNums.get(num1) / arabicNums.get(num2));
                            break;
                        default:
                            throw new IOException("Вывод ошибки, так как формат математической операции не " +
                                    "удовлетворяет заданию — два операнда и один оператор (+, -, /, *).");
                    }
                } else if (romanNums.containsKey(num1) && romanNums.containsKey(num2)) {
                    switch (operator) {
                        case "+":
                            System.out.println(arabicToRoman( romanNums.get(num1) + romanNums.get(num2)));
                            break;
                        case "-":
                            if (romanNums.get(num1) - romanNums.get(num2) >= 1) {
                                System.out.println(arabicToRoman(romanNums.get(num1) - romanNums.get(num2)));
                            } else {
                                throw new IOException("Вывод ошибки, так как в римской системе нет " +
                                        "отрицательных чисел.");
                            }
                            break;
                        case "*":
                            System.out.println(arabicToRoman(romanNums.get(num1) * romanNums.get(num2)));
                            break;
                        case "/":
                            System.out.println(arabicToRoman(romanNums.get(num1) / romanNums.get(num2)));
                            break;
                        default:
                            throw new IOException("Вывод ошибки, так как формат математической операции " +
                                    "не удовлетворяет заданию — два операнда и один оператор (+, -, /, *).");
                    }
                } else {
                    throw new IOException("Вывод ошибки, так как используются одновременно " +
                            "разные системы счисления");
                }
            }
        }
    }

    private static String arabicToRoman(int x) {
        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        if (x == 100) {
            return "C";
        } else {
            String t = tens[x / 10 % 10];
            String o = ones[x % 10];
            return t + o;
        }
    }
}