import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        System.out.print("Введите натуральное число: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int fact = 1;
            for (int i = 1; i <= N; i++) {
                fact = fact * i;
            }
            System.out.println("Факториал числа " + N + " равен " + fact);
        } else {
            System.out.println("Введите натуральное число!!");
        }
    }
}
