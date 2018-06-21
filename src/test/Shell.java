package test;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created by sbt-palamar-iy on 21.06.2018.
 */
public class Shell {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("введите команду>");
            String command = scanner.nextLine();

            switch (command) {
                case "time":
                    System.out.println(LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond());
                    break;
                case "date":
                    System.out.println(LocalDateTime.now().getDayOfMonth() + "." + LocalDateTime.now().getMonth() + "." + LocalDateTime.now().getYear());
                    break;
                case "quit":
                    System.exit(0);
                default:
                    System.out.println("Неизвестная команда!");
                    break;
            }
        }
    }
}