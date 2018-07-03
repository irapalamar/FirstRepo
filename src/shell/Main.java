package shell;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Shell shell = new Shell();
        shell.addCommand(new TimeCommand());
        shell.addCommand(new DateCommand());
        shell.addCommand(new Exit());
        shell.addCommand(new Factorial());
        shell.addCommand(new SortArray());
        shell.runShell();
    }
}
