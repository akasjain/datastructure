package patterns.observer;

/**
 * Sequence Diagram - https://howtodoinjava.com/wp-content/uploads/2019/01/observer_pattern_seq.png
 *
 * Class Diagram - https://howtodoinjava.com/wp-content/uploads/2019/01/observer-pattern-arch.jpg
 *
 * Article - https://howtodoinjava.com/design-patterns/behavioral/observer-design-pattern/
 */
public class Client {
    public static void main(String[] args) {
        MessageSubscriberOne s1 = new MessageSubscriberOne();
        MessageSubscriberTwo s2 = new MessageSubscriberTwo();

        MessagePublisher p = new MessagePublisher();

        p.attach(s1);
        p.attach(s2);

        Message m = new Message("akash", p);
        m.updateMessage("akash jain");
        m.updateMessage("ajunoit");
    }
}
