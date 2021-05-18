package rs.raf.web_d7.resources;


import rs.raf.web_d7.entities.Comment;
import rs.raf.web_d7.services.CommentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response create(Comment comment) {
        if (comment == null || comment.getContent() == null || comment.getPostId() == null || comment.getAuthor() == null){
            return Response.status(400,"All fields are required").build();
        }
        if (comment.getContent().equals("") || comment.getAuthor().equals("") ){
            return Response.status(400,"All fields are required").build();
        }
        return Response.ok(this.commentService.addComment(comment)).build();
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
