package Shell_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListCommand {
    private Scanner scanner = new Scanner(System.in);

    public void handle() {
        List list = new ArrayList();
        while (true) {
            showoutMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Содержимое списка: " + list);
                    break;

                case 2:
                    System.out.println("Список пуст: " + list.isEmpty());
                    break;

                case 3:
                    containsItem(list);
                    break;

                case 4:
                    addItem(list);
                    break;

                case 5:
                    addItemByIndex(list);
                    break;

                case 6:
                    getItemByIndex(list);
                    break;

                case 7:
                    removeItem(list);
                    break;
                case 8:
                    removeItemByIndex(list);
                    break;

                case 9:
                    return;

                default:
                    System.out.println("Неизвестная команда");
            }

        }
    }

    private static void showoutMenu() {
        System.out.println("Выберите действие над коллекцией: ");
        System.out.println("1. showItems");
        System.out.println("2. isEmpty");
        System.out.println("3. contains");
        System.out.println("4. add");
        System.out.println("5. addByIndex");
        System.out.println("6. getByIndex");
        System.out.println("7. remove");
        System.out.println("8. removeByIndex");
        System.out.println("9. goToMainMenu");

    }

    private void containsItem(List list) {
        System.out.println("Введите элемент: ");
        boolean contains = list.contains(scanner.next());
        System.out.println("Содержится ли элемент: " + contains);
    }

    private void addItem(List list) {
        System.out.println("Введите элемент: ");
        list.add(scanner.next());
        System.out.println("Элемент добавлен");
    }

    private void addItemByIndex(List list) {
        System.out.println("Введите позицию: ");
        int i = scanner.nextInt();
        System.out.println("Введите элемент: ");
        list.add(i, scanner.next());
        System.out.println("Элемент добавлен");
    }

    private void getItemByIndex(List list) {
        System.out.println("Введите позицию: ");
        int i = scanner.nextInt();
        System.out.println(list.get(i));
    }

    private void removeItem(List list) {
        System.out.println("Введите элемент: ");
        list.remove(scanner.next());
        System.out.println("Элемент удален");
    }

    private void removeItemByIndex(List list) {
        System.out.println("Введите позицию элемента: ");
        list.remove(scanner.nextInt());
        System.out.println("Элемент удален");
    }
}
