package patterns.observer;

public class Message {
    private String msg;
    private Subject subject;

    public Message(String msg, Subject subject) {
        this.msg = msg;
        this.subject = subject;
    }

    public void updateMessage(String newMsg) {
        msg = newMsg;
        subject.notifyUpdate(this);
    }

    public String getMsg() {
        return msg;
    }
}
