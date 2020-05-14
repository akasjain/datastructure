package patterns.decorator;

public class SupportReport implements Report {

    @Override
    public Object[][] getReportData(String reportId) {
        return new Object[0][];
    }

    @Override
    public String getFirstColumnData() {
        return "Support data";
    }
}
