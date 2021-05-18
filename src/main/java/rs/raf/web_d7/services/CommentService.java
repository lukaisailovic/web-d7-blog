package rs.raf.web_d7.services;

import rs.raf.web_d7.entities.Comment;
import rs.raf.web_d7.repositories.interfaces.ICommentRepository;

import javax.inject.Inject;
import java.util.List;

public class CommentService {

    @Inject
    private ICommentRepository commentRepository;

    public Comment addComment(Comment comment){
        return this.commentRepository.add(comment);
    }
    public List<Comment> allComments(){
        return this.commentRepository.all();
    }
    public Comment findComment(Integer id){
        return this.commentRepository.find(id);
    }
    public void deleteComment(Integer id){
        this.commentRepository.delete(id);
    }
}
