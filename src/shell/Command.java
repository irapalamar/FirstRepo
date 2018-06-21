package shell;

public interface Command {
    String getName();
    void executed(String[] args);
}
