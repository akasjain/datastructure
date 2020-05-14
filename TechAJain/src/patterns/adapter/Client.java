package patterns.adapter;

/**
 * Sequence Diagram - https://howtodoinjava.com/wp-content/uploads/2014/05/adapter_sequence.png
 *
 * Class Diagram -
 *
 * https://howtodoinjava.com/design-patterns/structural/adapter-design-pattern-in-java/
 *
 * https://learning.oreilly.com/videos/design-patterns-in/9781771374040/9781771374040-video214998
 */
public class Client {
    public static void main(String[] args) {
        Logger logger = Logger.create();
        logger.debug("Some debug message");
        logger.trace("Some trace message");
        logger.log("Some log message");
    }
}
