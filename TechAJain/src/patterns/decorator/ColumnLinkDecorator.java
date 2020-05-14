package patterns.decorator;

public class ColumnLinkDecorator extends ColumnDecorator {

    public ColumnLinkDecorator(Report report) {
        super(report);
    }

    @Override
    public String getFirstColumnData() {
        return addLink(super.getFirstColumnData());
    }

    String addLink(String columnData) {
        return columnData + " Link added ";
    }
}
