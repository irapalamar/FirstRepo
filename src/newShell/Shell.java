package newShell;

import shell.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.System;


    public class Shell {
        private Map<String, Command> commands = new HashMap<>();

        public void runShell() {
            for (Command command : commands.values()) {
                System.out.println(command.getName());
            }



             /*   String commandName = scanner.nextLine();
                if (commands.containsKey(commandName))
                    commands.get(commandName).executed(new String[]{});
                else
                    System.out.println("Команды " + commandName + " не существует");
            }*/
        }
            public void addCommand (Command c){
                commands.put(c.getName(), c);
            }
        }

