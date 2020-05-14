package patterns.mediator;

public abstract class User {
    Chat mediator;
    String id;
    String name;

    public User(Chat mediator, String id, String name) {
        this.mediator = mediator;
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Chat getMediator() {
        return mediator;
    }

    public abstract void send(String msg, String userId);
    public abstract void receive(String msg);
}
