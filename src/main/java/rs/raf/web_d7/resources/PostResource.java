package rs.raf.web_d7.resources;


import rs.raf.web_d7.entities.Post;
import rs.raf.web_d7.services.PostService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/posts")
public class PostResource {

    @Inject
    private PostService postService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> all(){
        return this.postService.allPosts();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@BeanParam Post post) {
        if (post == null || post.getContent() == null || post.getTitle() == null || post.getAuthor() == null){
            return Response.status(400,"All fields are required").build();

        }
        if (post.getContent().equals("") || post.getAuthor().equals("") || post.getTitle().equals("")){
            return Response.status(400,"All fields are required").build();
        }
        return Response.ok(this.postService.addPost(post)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post get(@PathParam("id") Integer id){
        return this.postService.findPost(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Integer id){
         this.postService.deletePost(id);
    }
}
