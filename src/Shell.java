import java.lang.System;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("тест 1454121656");
        System.out.print("тест 8789787987");
        while(true) {
            System.out.print("введите команду>");
            String str = scanner.nextLine();
            switch (str) {
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
