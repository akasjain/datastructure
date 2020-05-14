package patterns.mediator;

public interface Chat {
    void sendMessage(String message, String userId);
    void addUser(User u);
}
