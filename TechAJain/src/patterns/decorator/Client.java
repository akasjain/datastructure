package patterns.decorator;

/**
 * Class - https://howtodoinjava.com/wp-content/uploads/decorator-design-pattern-participants.png
 *
 * https://howtodoinjava.com/design-patterns/structural/decorator-design-pattern/
 */
public class Client {

    public static void main(String[] args) {
        ColumnPopupDecorator decoratedReport = new ColumnPopupDecorator(new ColumnLinkDecorator(new SupportReport()));
        System.out.println(decoratedReport.getFirstColumnData());
    }
}
