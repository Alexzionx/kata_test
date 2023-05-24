import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyEx {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        String input = scanner.nextLine();
        String arrayInput[] = input.split(" ");
        int a = 0;
        boolean aIsRome = false;
        int b = 0;
        boolean bIsRome = false;
        int result = 0;
        String output = "";

        try {
            a = Integer.valueOf(arrayInput[0]);

        } catch (Exception e) {
            aIsRome = true;
            a = main.romeToInt(arrayInput[0]);
        }
        try {
            b = Integer.valueOf(arrayInput[2]);

        } catch (Exception e) {
            bIsRome = true;
            b = main.romeToInt(arrayInput[2]);
        }
        if (a > 10 | b > 10) {
            throw new MyEx("числа больше 10-ти");}
        if (aIsRome != bIsRome) {
           throw new MyEx("одно из чисел введено по арабски, а другое по римски");
        }
        switch (arrayInput[1]) {
            case "+" -> {
                result = a + b;
            }
            case "-" -> {
                result = a - b;
            }
            case "*" -> {
                result = a * b;
            }
            case "/" -> {
                result = a / b;
            }
        }
        if (aIsRome) {
            output = main.intToRome(result);
        } else {
            output = String.valueOf(result);
        }
        System.out.println(output);
    }

    int romeToInt(String s) throws MyEx {
        switch (s) {
            case "I" -> {
                return 1;
            }
            case "II" -> {
                return 2;
            }
            case "III" -> {
                return 3;
            }
            case "IV" -> {
                return 4;
            }
            case "V" -> {
                return 5;
            }
            case "VI" -> {
                return 6;
            }
            case "VII" -> {
                return 7;
            }
            case "VIII" -> {
                return 8;
            }
            case "IX" -> {
                return 9;
            }
            case "X" -> {
                return 10;
            }
            default -> {
                throw new MyEx("Римская цифра введена не правильно либо она больше 10-ти");
            }
        }
    }

    String intToRome(int num) throws MyEx {
        String[] rome = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX","LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC","XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s="";
        try {
            s = rome[num];
        }catch (Exception e){
            throw new MyEx("Римское число не может быть отрицательным, а ведь именно такой ответ и получился");
        }
        return s;
    }
}
class MyEx extends Exception{
    public MyEx(String info){
        super(info);
    }
}
