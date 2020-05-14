package patterns.chaninofresponsibility;

public class ServiceSupportImpl implements ServiceSupport {

    private ServiceSupport handler;

    public ServiceSupport getHandler() {
        return handler;
    }

    public void setHandler(ServiceSupport handler) {
        this.handler = handler;
    }

    @Override
    public void handleRequest(ServiceRequest req) {
        // Do some book keeping with the request
        handler.handleRequest(req);
    }
}
