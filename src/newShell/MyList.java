package newShell;

public class MyList implements Command {
    @Override
    public String getName() {
        return "list";
    }

    @Override
    public void executed(String[] args) {
        System.out.println("List");
    }
}
