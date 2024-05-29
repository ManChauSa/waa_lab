package lab_1.service;

import lab_1.entity.Post;
import lab_1.entity.dto.response.PostDto;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    PostDto getById(long id);
    void add(PostDto param);
    void delete(long id);
    void update(int id, PostDto p);
    List<PostDto> getbyAuthor(String author);
    List<PostDto> getbyAuthorContains(String text);

}
