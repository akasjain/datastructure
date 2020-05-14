package patterns.observer;

public class MessageSubscriberTwo implements Observer {
    Message message;

    @Override
    public void update(Message m) {
        this.message = m;
        logMessage();
    }

    private void logMessage() {
        System.out.println("Logging " + message.getMsg());
    }
}
