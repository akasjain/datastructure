package patterns.command.receiver;

public class Fan {
    public void start() {
        System.out.println("Fan turned ON");
    }
    public void stop() {
        System.out.println("Fan turned OFF");
    }
}
