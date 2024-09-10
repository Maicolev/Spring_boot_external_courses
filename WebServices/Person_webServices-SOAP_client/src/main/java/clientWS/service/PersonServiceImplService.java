package clientWS.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.4
 * 2024-09-09T22:09:57.079-05:00
 * Generated source version: 4.0.4
 *
 */
@WebServiceClient(name = "PersonServiceImplService",
                  wsdlLocation = "http://localhost:8080/PersonServiceImplService/PersonServiceImpl?wsdl",
                  targetNamespace = "http://impl.services/")
public class PersonServiceImplService extends Service {

    public static final URL WSDL_LOCATION;

    public static final QName SERVICE = new QName("http://impl.services/", "PersonServiceImplService");
    public static final QName PersonServiceImplPort = new QName("http://impl.services/", "PersonServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/PersonServiceImplService/PersonServiceImpl?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PersonServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/PersonServiceImplService/PersonServiceImpl?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PersonServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PersonServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PersonServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public PersonServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PersonServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PersonServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns PersonServiceWs
     */
    @WebEndpoint(name = "PersonServiceImplPort")
    public PersonServiceWs getPersonServiceImplPort() {
        return super.getPort(PersonServiceImplPort, PersonServiceWs.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PersonServiceWs
     */
    @WebEndpoint(name = "PersonServiceImplPort")
    public PersonServiceWs getPersonServiceImplPort(WebServiceFeature... features) {
        return super.getPort(PersonServiceImplPort, PersonServiceWs.class, features);
    }

}