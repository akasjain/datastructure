package patterns.chaninofresponsibility;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.xml.internal.xsom.XSUnionSimpleType;

/**
 * Class Diagram - https://howtodoinjava.files.wordpress.com/2013/04/chainofresponsibility_classdiagram.png
 *
 * Article - https://howtodoinjava.com/design-patterns/behavioral/chain-of-responsibility-design-pattern/
 */
public class Client {

    public static void main(String[] args) {
        ServiceRequest request = new ServiceRequest(ServiceLevel.LEVEL_THREE);
        ServiceSupportImpl svcSupport = new ServiceSupportImpl();
        FrontDeskSupport fdSupport = new FrontDeskSupport();
        SupervisorSupport supSupport = new SupervisorSupport();
        fdSupport.setNext(supSupport);
        svcSupport.setHandler(fdSupport);

        try {
            svcSupport.handleRequest(request);
            System.out.println(request.getConclusion());
        } catch(IllegalArgumentException e) {
            System.out.println(e.toString());
        }

    }
}
