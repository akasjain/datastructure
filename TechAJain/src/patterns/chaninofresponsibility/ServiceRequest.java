package patterns.chaninofresponsibility;

public class ServiceRequest {

    ServiceLevel level;
    String conclusion;

    public ServiceRequest(ServiceLevel level) {
        this.level = level;
    }

    public ServiceLevel getLevel() {
        return level;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
