package lab_1.repo;

import lab_1.entity.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> getAll();
    public Post getbyId(long id);
    public void add(Post param);
    public void delete(long id);
    public void update(long id, Post param);
    public List<Post> getbyAuthor(String author);
    public List<Post> getbyAuthorContains(String text);
}
