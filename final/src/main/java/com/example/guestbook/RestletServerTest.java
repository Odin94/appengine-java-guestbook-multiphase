import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;
 
public class RestletServerTest extends ServerResource {
 
    public static void main(final String[] args) throws Exception {
        // Create a new Component.
        final Component component = new Component();
         
        // Add a new HTTP server listening on port 8080.
        component.getServers().add(Protocol.HTTP, 8080);
         
        final Router router = new Router(component.getContext().createChildContext());
         
        router.attach("/test", RestletServerTest.class);
         
        // Attach the sample application.
        component.getDefaultHost().attach("/restlet", router);
         
        // Start the component.
        component.start();
    }
     
    @Override
    @Get
    public String toString() {
        return "hello, world";
    }
 
}