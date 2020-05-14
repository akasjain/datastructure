package patterns.decorator;

public class ColumnPopupDecorator extends ColumnDecorator {

    public ColumnPopupDecorator(Report report) {
        super(report);
    }

    @Override
    public String getFirstColumnData() {
        return designPopup(super.getFirstColumnData());
    }

    private String designPopup(String firstColumnData) {
        return firstColumnData + "Popup decorated";
    }
}
