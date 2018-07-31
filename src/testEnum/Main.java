package testEnum;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, List<Voter>> voters = new HashMap<>();

    public static void main(String[] args) {

        voters.put("1", new ArrayList<Voter>());
        voters.put("2", new ArrayList<Voter>());
        voters.put("3", new ArrayList<Voter>());

        while (true) {
            showOutMenu();
            switch (scanner.nextInt()) {
                case 1:
                    vote();
                    break;
                case 2:
                    votingStats();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void votingStats() {
        System.out.println("РЕЗУЛЬТАТЫ ГОЛОСОВАНИЯ:");
        for (String s : voters.keySet()) {
            System.out.println(s + ": " + voters.get(s).size());
            for (AgeCategory a : AgeCategory.values()) {
                int count = 0;
                for (Voter v : voters.get(s)) {
                    if (v.getAgeCategory() == a) {
                        count++;
                    }
                }
                System.out.println("    " + a.name() + ": " + count);
            }
        }
    }

    private static void showOutMenu() {
        System.out.println("1 – Проголосовать\n" +
                "2 – Вывести статистику\n" +
                "3 – Выход");
    }

    private static void vote() {
        System.out.println("Выберите пол: \n" +
                "1. Мужской\n" +
                "2. Женский");
        int i = scanner.nextInt();
        Gender gender;
        switch (i){
            case 1: gender = Gender.MALE;
                break;
            case 2:  gender = Gender.FEMALE;
                break;
            default: throw new IllegalArgumentException();
        }
        System.out.println("Введите возраст: ");
        int age = scanner.nextInt();
        System.out.println("Выберите кандидата:");
        for (String s : voters.keySet()) {
            System.out.println(s);
        }
     //   String candidate = scanner.next();
        int candidate = scanner.nextInt();
        Voter voter = getVoter(gender, age);
        if (voters.containsKey(candidate)) {
            voters.get(candidate).add(voter);
            System.out.println("Голос засчитан!");
        } else {
            System.out.println("Такого кандидата нет!");
        }
    }

    private static Voter getVoter(Gender gender, int age) {
        switch (gender) {
            case MALE:
                return new Man(age);

            case FEMALE:
                return new Woman(age);
        }
        return null;
    }

}


