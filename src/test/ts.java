package test;

import java.util.*;

public class ts {
    package ru.sbrf.learn.generics.voting;

import java.util.*;

    public class MainVoting {
        private static Scanner scanner = new Scanner(System.in);
        private static Map<String, List<Voter>> votingResults = new HashMap<>();

        public static void main(String[] args) {

            votingResults.put("Путин", new ArrayList<Voter>());
            votingResults.put("Жириновский", new ArrayList<Voter>());
            votingResults.put("Грудинин", new ArrayList<Voter>());

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
            for(String s : votingResults.keySet()){
                System.out.println(s + ": " + votingResults.get(s).size());
                for (AgeCategory a:AgeCategory.values()) {
                    int count = 0;
                    for (Voter v : votingResults.get(s)){
                        if (v.getAgeCategory() == a){
                            count++;
                        }
                    }
                    System.out.println("    "+a.name() + ": " + count);
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
            Gender gender = Gender.valueOf(scanner.nextInt());
            System.out.println("Введите возраст: ");
            int age = scanner.nextInt();
            System.out.println("Выберите кандидата:");
            for (String s : votingResults.keySet()){
                System.out.println(s);
            }
            String candidate = scanner.next();
            Voter voter  = getVoter(gender, age);
            if (votingResults.containsKey(candidate)){
                votingResults.get(candidate).add(voter);
                System.out.println("Голос засчитан!");
            } else{
                System.out.println("Такого кандидата нет!");
            }
        }

        private static Voter getVoter(Gender gender, int age) {
            switch (gender) {
                case MALE:
                    return new VoterMan(age);

                case FEMALE:
                    return new VoterFemale(age);
            }
            return null;
        }
    }

}
