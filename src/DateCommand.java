import java.time.LocalDateTime;

public class DateCommand implements Command {
    @Override
    public String getName() {
        return "date";
    }

    @Override
    public void executed(String[] args) {
        System.out.println(LocalDateTime.now().getDayOfMonth() + "." + LocalDateTime.now().getMonth() + "." + LocalDateTime.now().getYear());
    }
}
