public class Main {

    public static void main(String[] args){
        Shell shell = new Shell();
        shell.addCommand(new TimeCommand());
        shell.addCommand(new DateCommand());
        shell.addCommand(new Exit());
        shell.runShell();
    }
}
