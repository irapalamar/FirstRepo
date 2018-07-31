package testEnum;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, List<Voter>> voters = new HashMap<>();

    public static void main(String[] args) {

        voters.put("1", new ArrayList<>());
        voters.put("2", new ArrayList<>());
        voters.put("3", new ArrayList<>());

        while (true) {
            showMenu();
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
        System.out.println("Выберите признак, по которому вы хотите получить статистику:" +
                " 1. Возрастной " +
                " 2. Половой ");
    }

    private static void vote() {
        Gender gender;
        System.out.println("Ваш пол: 1. Женский 2. Мужской ");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                gender = Gender.FEMALE;
                break;
            case 2:
                gender = Gender.MALE;
                break;
            default: throw new IllegalArgumentException();
        }
        System.out.println("Ваш возраст: ");
        int age = scanner.nextInt();
        System.out.println("Выберите кандидата:");
        for (String voter : voters.keySet()) {
            System.out.println(voter);
        }
        String candidate = scanner.next();
        Voter voter = getVoter(gender, age);
        if (voters.containsKey(candidate)) {
            voters.get(candidate).add(voter);
        } else {
            System.out.println("Выберите существующего кандидата!");
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

    private static void showMenu() {
        System.out.println("Выберите действие: ");
        System.out.println("1 - Проголосовать");
        System.out.println("2 - Вывести статистику");
        System.out.println("3 - Выход");
    }


}


