import java.lang.System;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shell {
    private Map<String,Command> commands = new HashMap<>();

    public void runShell(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("введите команду>");
            String commandName = scanner.nextLine();
            if (commands.containsKey(commandName))
                commands.get(commandName).executed(new String[]{});
            else
                System.out.println("Команды "  + commandName + " не существует");
        }
    }

    public void addCommand(Command c){
        commands.put(c.getName(),c);
    }

   /* public static void main(String[] args) {



        /* Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("введите команду>");
            String command = scanner.nextLine();

           switch (command) {
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
            }*/

   }


