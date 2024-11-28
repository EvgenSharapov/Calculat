import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        printResult(text);

    }

    private static void printResult(String text) {

        List<String> parts = Arrays.stream(text.split("(?<=[-+*/])|(?=[-+*/])"))
                .map(String::trim)
                .toList();

        if (parts.size() != 3) {
            System.out.print("throws Exception");
        }
        int a = 0;
        int b = 0;

        if(parts.getFirst().matches("^-?\\d+$")){
            a = Integer.parseInt(parts.getFirst());
        }
        else {
            System.out.print("throws Exception");
            System.exit(0);
        }
        if(parts.get(2).matches("^-?\\d+$")){
            b = Integer.parseInt(parts.get(2));
        }
        else{System.out.print("throws Exception");
            System.exit(0);
        }

        String c = parts.get(1);

        if (a > 10 || a < 1 || b > 10 || b < 1 || !(c.equals("*") || c.equals("/") || (c.equals("+")) || (c.equals("-")))) {
            System.out.print("throws Exception");
        } else {
            switch (c) {
                case "*" -> System.out.print(a * b);
                case "-" -> System.out.print(a - b);
                case "/" -> System.out.print(a / b);
                case "+" -> System.out.print(a + b);
            }
        }
    }
}
