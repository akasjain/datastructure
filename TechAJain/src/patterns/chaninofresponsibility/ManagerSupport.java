package patterns.chaninofresponsibility;

public class ManagerSupport implements ServiceSupport {

    ServiceSupport next;

    public ServiceSupport getNext() {
        return next;
    }

    public void setNext(ServiceSupport next) {
        this.next = next;
    }

    @Override
    public void handleRequest(ServiceRequest req) {
        if(req.getLevel() == ServiceLevel.LEVEL_THREE) {
            req.setConclusion("You request is completed by manager");
        } else {
            if(next != null) {
                next.handleRequest(req);
            } else {
                throw new IllegalArgumentException("No handler found for :: " + req.getLevel());
            }
        }
    }
}
