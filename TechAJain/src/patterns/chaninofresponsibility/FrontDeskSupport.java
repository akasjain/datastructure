package patterns.chaninofresponsibility;

public class FrontDeskSupport implements ServiceSupport {

    ServiceSupport next;

    public ServiceSupport getNext() {
        return next;
    }

    public void setNext(ServiceSupport next) {
        this.next = next;
    }

    @Override
    public void handleRequest(ServiceRequest req) {
        if(req.getLevel() == ServiceLevel.LEVEL_ONE) {
            req.setConclusion("You request is completed");
        } else {
            if(next != null) {
                next.handleRequest(req);
            } else {
                throw new IllegalArgumentException("No handler found for :: " + req.getLevel());
            }
        }
    }
}
