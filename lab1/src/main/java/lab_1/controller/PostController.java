package lab_1.controller;

import lab_1.entity.Post;
import lab_1.entity.dto.response.PostDto;
import lab_1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAll(){
        return  postService.getAll();
    }

    @GetMapping("/{id}")
    public PostDto getbyId(@PathVariable("id") long id){
        return postService.getById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    public void add(@RequestBody PostDto p){
        postService.add(p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        postService.delete(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody PostDto p) {
        postService.update(id,p);
    }

    @GetMapping("/filter/{author}")
    public List<PostDto> getPostsByAuthor(@PathVariable String author) {
        return postService.getbyAuthor(author);
    }

    @GetMapping("/search/{text}")
    public List<PostDto> getPostsByAuthorContains(@PathVariable String text) {
        return postService.getbyAuthorContains(text);
    }
}
