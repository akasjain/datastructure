package patterns.mediator;

/**
 * Class - https://howtodoinjava.com/wp-content/uploads/2019/01/Mediator_design_pattern.png
 *
 *https://howtodoinjava.com/design-patterns/behavioral/mediator-pattern/
 *
 * Mediator pattern is used when you objects want to communicate with each other. They do not communicate directly, instead use a mediator who has knowledge
 * of all objects and is therefore able to communicate on their behalf
 */
public class Client {
    public static void main(String[] args) {
        Chat chatroom = new ChatApp();

        User user1 = new ChatUser(chatroom,"1", "Alex");
        User user2 = new ChatUser(chatroom,"2", "Brian");
        User user3 = new ChatUser(chatroom,"3", "Charles");
        User user4 = new ChatUser(chatroom,"4", "David");

        chatroom.addUser(user1);
        chatroom.addUser(user2);
        chatroom.addUser(user3);
        chatroom.addUser(user4);

        user1.send("Hello brian", "2");
        user2.send("Hey buddy", "1");
    }
}
