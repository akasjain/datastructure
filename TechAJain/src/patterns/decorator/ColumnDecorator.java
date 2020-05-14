package patterns.decorator;

public abstract class ColumnDecorator implements Report{

    Report report;

    public ColumnDecorator(Report report) {
        this.report = report;
    }

    @Override
    public Object[][] getReportData(String reportId) {
        return report.getReportData(reportId);
    }

    @Override
    public String getFirstColumnData() {
        return report.getFirstColumnData();
    }
}
