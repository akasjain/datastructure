package patterns.mediator;

public class ChatUser extends User {


    public ChatUser(Chat mediator, String id, String name) {
        super(mediator, id, name);
    }

    @Override
    public void send(String msg, String userId) {
        getMediator().sendMessage(msg, userId);
    }

    @Override
    public void receive(String message) {
        System.out.println("Message received " + message);
    }

}
