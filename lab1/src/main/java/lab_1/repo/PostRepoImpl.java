package lab_1.repo;

import lab_1.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static  List<Post> posts;
    private static int postId = 200;
    static {
        posts = new ArrayList<>();
        Post p1 = new Post(100L,"titile_100","content_100","author_100");
        Post p2 = new Post(101L,"titile_101","content_101","author_101");
        posts.add(p1);
        posts.add(p2);
    }
    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post getbyId(long id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Post param) {
        param.setId(postId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        postId++;
        posts.add(param);
    }

    @Override
    public void delete(long id) {
        var post =posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public void update(long id, Post param) {
        Post toUpdate = getbyId(id);
        toUpdate.setTitle(param.getTitle());
        toUpdate.setContent(param.getContent());
    }

    @Override
    public List<Post> getbyAuthor(String author) {
        List<Post> result = new ArrayList<Post>();
        return posts.stream()
                .filter(p -> p.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
//        for (Post post :posts){
//            if(post.getAuthor().contains(author)){
//                result.add(post);
//            }
//        }
//        return result;
    }

    @Override
    public List<Post> getbyAuthorContains(String text) {
        List<Post> result = new ArrayList<Post>();
        for (Post post :posts){
            if(post.getAuthor().contains(text)){
                result.add(post);
            }
        }
        return result;
    }
}
