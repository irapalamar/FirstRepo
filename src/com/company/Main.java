package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
       // List list = new ArrayList();
       // Random r = new Random();
        /*System.out.println("Введите кол-во элементов массива:");
        Scanner scanner = new Scanner(System.in);
        int longArray = scanner.nextInt();
        int longArray = 10;
        for (int i = 0; i < longArray; i++) {
            list.add(r.nextInt(100));
        }
        printList(list);
        list.add(99);
        list.add(4, 99);
        printList(list);
        list.add(8, 55);
        printList(list);
        list.add(11, 55);
        printList(list);
        list.remove(new Integer(99));
        printList(list);
        list.set(0,0);
        printList(list);
        System.out.println("Элемент 5 позиции: " + list.get(5) );
        System.out.println("Индекс первого элемента 55: " + list.indexOf(55) );
        System.out.println("Индекс последнего элемента 55: " + list.lastIndexOf(55) );
        list.remove(0);
        printList(list);
        List list2 = list.subList(3,8);
        printList(list2);
        System.out.println("Список пуст? " + list.isEmpty());
        System.out.println("Есть элемент 55? " + list.contains(55));
        System.out.println("Есть элемент 99? " + list.contains(99));
        list.clear();
        System.out.println("Удаляем все элементы");
        System.out.println("Список пуст? " + list.isEmpty());*/
        LinkedList linkList = new LinkedList();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            linkList.add(r.nextInt(100));
        }
        printList(linkList);
        linkList.addFirst(22);
        System.out.print("Добавили в начало: ");
        printList(linkList);
        System.out.println("Размер: " + linkList.size());
        linkList.addLast(22);
        System.out.print("Добавили в конец: ");
        printList(linkList);
        System.out.println("Есть ли элемент 22? " + linkList.contains(22));
        System.out.print("Удалили первый: ");
        linkList.removeFirst();
        printList(linkList);
        System.out.print("Удалили последний: ");
        linkList.removeLast();
        printList(linkList);
        System.out.println("Есть ли элемент 22? " + linkList.contains(22));
        System.out.println("Первый: " + linkList.getFirst());
        System.out.println("Последний: " + linkList.getLast());
        System.out.print("Удалили первый: ");
        linkList.pollFirst();
        printList(linkList);
        System.out.print("Удалили последний: ");
        linkList.pollLast();
        printList(linkList);
        System.out.print("Добавили 55 на 3,6 и 8 позицию: ");
        linkList.add(3,55);
        linkList.add(6,55);
        linkList.add(8,55);
        printList(linkList);
        System.out.print("Удалили с 8 позиции: ");
        linkList.remove(8);
        printList(linkList);
        System.out.print("Удалили число 55: ");
        linkList.remove(new Integer(55));
        printList(linkList);
        linkList.set(7,88);
        System.out.print("Заменили на 7 позиции значение на 88: ");
        printList(linkList);
        System.out.println("Находим значение 4 позиции: " + linkList.get(4));
        System.out.println("Находим индекс числа 55: " + linkList.indexOf(55));
        List list2 = linkList.subList(3,7);
        printList(list2);
        linkList.clear();

    }

    public static void printList(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
