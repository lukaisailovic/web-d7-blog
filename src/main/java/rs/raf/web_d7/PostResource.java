package rs.raf.web_d7;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/posts")
public class PostResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Some posts";
    }
}