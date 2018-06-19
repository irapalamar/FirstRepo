import java.time.LocalDateTime;

public class TimeCommand implements Command {
    @Override
    public String getName() {
        return "time";
    }

    @Override
    public void executed(String[] args) {
        System.out.println(LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond());
    }
}
