package rs.raf.web_d7.repositories.interfaces;

import rs.raf.web_d7.entities.Comment;

import java.util.List;

public interface ICommentRepository {
    public Comment add(Comment obj);
    public List<Comment> all();
    public Comment find(Integer id);
    public List<Comment> findByPost(Integer id);
    public void delete(Integer id);

}
