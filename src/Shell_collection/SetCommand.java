package Shell_collection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetCommand {
    private Scanner scanner  = new Scanner(System.in);
    public void handle(){
        Set set = new HashSet();
        while(true){
            showoutMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Содержимое списка: " + set);
                    break;

                case 2:
                    System.out.println("Список пуст: " + set.isEmpty());
                    break;

                case 3:
                    containsItem(set);
                    break;

                case 4:
                    addItem(set);
                    break;

                case 5:
                    removeItem(set);
                    break;

                case 6:
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
        System.out.println("5. remove");
        System.out.println("6. goToMainMenu");

    }

    private void containsItem(Set set) {
        System.out.println("Введите элемент: ");
        boolean contains = set.contains(scanner.next());
        System.out.println("Содержится ли элемент: " + contains);
    }

    private void addItem(Set set) {
        System.out.println("Введите элемент: ");
        set.add(scanner.next());
        System.out.println("Элемент добавлен");
    }
    private void removeItem(Set set) {
        System.out.println("Введите элемент: ");
        set.remove(scanner.next());
        System.out.println("Элемент удален");
    }
}
