package Shell_collection;

import java.util.Scanner;

public class Shell {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        showoutMenu();
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                new ListCommand().handle();
                break;

            case 2:
                new SetCommand().handle();
                break;

            case 3:
                new DequeCommand().handle();
                break;

           /* case 4:
                new MapCommand().handle();
                break;*/

            case 0:
                return;

            default:
                System.out.println("Неизвестная команда");
        }

    }


    private static void showoutMenu() {
        System.out.println("Выберите тип коллекции: ");
        System.out.println("1. List");
        System.out.println("2. Set");
        System.out.println("3. Deque");
        System.out.println("4. Map");
    }
}


