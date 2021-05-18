package rs.raf.web_d7.repositories.interfaces;

import rs.raf.web_d7.entities.Post;

import java.util.List;

public interface IPostRepository {

    public Post add(Post obj);
    public List<Post> all();
    public Post find(Integer id);
    public void delete(Integer id);
}
