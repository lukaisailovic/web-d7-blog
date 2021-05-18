package rs.raf.web_d7;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import rs.raf.web_d7.repositories.CommentRepository;
import rs.raf.web_d7.repositories.PostRepository;
import rs.raf.web_d7.repositories.interfaces.ICommentRepository;
import rs.raf.web_d7.repositories.interfaces.IPostRepository;
import rs.raf.web_d7.services.CommentService;
import rs.raf.web_d7.services.PostService;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class BlogApplication extends ResourceConfig {
    public BlogApplication() {

        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);

        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(PostRepository.class).to(IPostRepository.class).in(Singleton.class);
                this.bind(CommentRepository.class).to(ICommentRepository.class).in(Singleton.class);

                this.bindAsContract(PostService.class);
                this.bindAsContract(CommentService.class);
            }
        };
        register(binder);

        packages("rs.raf.web_d7.resources");
    }
}