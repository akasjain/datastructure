package patterns.iterator;

/**
 * Class diagram - https://howtodoinjava.com/wp-content/uploads/2018/12/Iterator-Class-Diagram.jpg
 *
 * https://howtodoinjava.com/design-patterns/behavioral/iterator-design-pattern/
 *
 */
public class Client {

    public static void main(String[] args) {
        Topic[] topics = new Topic[5];
        topics[0] = new Topic("topic1");
        topics[1] = new Topic("topic2");
        topics[2] = new Topic("topic3");
        topics[3] = new Topic("topic4");
        topics[4] = new Topic("topic5");

        List<Topic> list = new TopicList(topics);

        Iterator<Topic> iterator = list.iterator();

        while(iterator.hasNext()) {
            Topic currentTopic = iterator.next();
            System.out.println(currentTopic.getName());
        }

    }
}
