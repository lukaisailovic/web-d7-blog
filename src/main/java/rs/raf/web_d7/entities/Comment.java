package rs.raf.web_d7.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Comment {

    private Integer id;

    private Integer postId;

    @NotNull(message = "Author is required")
    @NotEmpty(message = "Author is required")
    private String author;

    @NotNull(message = "Content is required")
    @NotEmpty(message = "Content is required")
    private String content;

    public Comment(){

    }

    public Comment(Integer postId,String author, String content) {
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public Comment(Integer id, Integer postId, String author, String content) {
        this.id = id;
        this.postId = postId;
        this.author = author;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + postId +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
