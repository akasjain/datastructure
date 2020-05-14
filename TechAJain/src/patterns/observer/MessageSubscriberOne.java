package patterns.observer;

public class MessageSubscriberOne implements Observer {
    Message message;

    @Override
    public void update(Message m) {
        this.message = m;
        printMessage();
    }

    private void printMessage() {
        System.out.println("Printing : " + message.getMsg());

    }
}
