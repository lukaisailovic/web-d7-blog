package rs.raf.web_d7.resources;


import rs.raf.web_d7.entities.Comment;
import rs.raf.web_d7.services.CommentService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/comments")
public class CommentResource {

    @Inject
    private CommentService commentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> all(@QueryParam("postId") Integer postId){
        if (postId == null){
            return this.commentService.allComments();
        }
        return this.commentService.findByPostId(postId);
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Comment create(@Valid Comment comment) {
        return this.commentService.addComment(comment);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment get(@PathParam("id") Integer id){
      return this.commentService.findComment(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Integer id){
        this.commentService.deleteComment(id);
    }
}
