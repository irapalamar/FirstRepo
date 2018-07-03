package shell;

import java.lang.System;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shell {
    private Map<String, Command> commands = new HashMap<>();

    public void runShell() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("введите команду>");
            String commandName = scanner.nextLine();
            if (commands.containsKey(commandName))
                commands.get(commandName).executed(new String[]{});
            else
                System.out.println("Команды " + commandName + " не существует");
        }
    }

    public void addCommand(Command c) {
        commands.put(c.getName(), c);
    }

    public class Help implements Command{

        @Override
        public String getName() {
            return "help";
        }

        @Override
        public void executed(String[] args) {
            for (Command command:commands.values()){
                System.out.println(command.getName());
            }
        }
    }
}


