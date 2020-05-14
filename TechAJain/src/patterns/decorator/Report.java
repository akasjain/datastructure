package patterns.decorator;

public interface Report {
    Object[][] getReportData(String reportId);
    String getFirstColumnData();
}
