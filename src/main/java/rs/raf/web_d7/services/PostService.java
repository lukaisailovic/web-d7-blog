package rs.raf.web_d7.services;

import rs.raf.web_d7.entities.Post;
import rs.raf.web_d7.repositories.interfaces.IPostRepository;

import javax.inject.Inject;
import java.util.List;

public class PostService {

    @Inject
    private IPostRepository postRepository;

    public Post addPost(Post post){
        return this.postRepository.add(post);
    }
    public List<Post> allPosts(){
        return this.postRepository.all();
    }
    public Post findPost(Integer id){
        return this.postRepository.find(id);
    }
    public void deletePost(Integer id){
        this.postRepository.delete(id);
    }
}
