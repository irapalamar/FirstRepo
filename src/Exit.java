import java.time.LocalDateTime;

public class Exit implements Command {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void executed(String[] args) {
        System.exit(0);
    }
}
