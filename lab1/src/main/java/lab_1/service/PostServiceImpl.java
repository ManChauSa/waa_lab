package lab_1.service;

import lab_1.entity.Post;
import lab_1.entity.dto.response.PostDto;
import lab_1.helper.ListMapper;
import lab_1.repo.PostRepo;
import lab_1.service.Interface.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
//    @Autowired
    PostRepo postRepo;

    PostServiceImpl(PostRepo postRepo){
        this.postRepo = postRepo;
    }
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(postRepo.findById((int)id),PostDto.class);
    }

    @Override
    public void add(PostDto param) {
         postRepo.save(modelMapper.map(param, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById((int)id);
    }

    @Override
    public void update(long id, PostDto p) {

        Optional<Post> optionalPost = postRepo.findById((int) id);
        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();

            // Map specific fields from PostDto to existing Post entity
            if (p.getTitle() != null) {
                existingPost.setTitle(p.getTitle());
            }
            if (p.getContent() != null) {
                existingPost.setContent(p.getContent());
            }
            if (p.getAuthor() != null) {
                existingPost.setAuthor(p.getAuthor());
            }

            postRepo.save(existingPost);
        }

    }
    @Override
    public List<PostDto> getbyAuthor(String author) {
        List<PostDto> result = new ArrayList<PostDto>();
        for(Post post : postRepo.findAll()) {
            if (post.getAuthor().equals(author)) {
                result.add(modelMapper.map(post, PostDto.class));
            }
        }
        return result;
    }

    @Override
    public List<PostDto> getbyAuthorContains(String text) {
        List<PostDto> result = new ArrayList<PostDto>();
        for(Post post : postRepo.findAll()) {
            if (post.getAuthor().contains(text)) {
                result.add(modelMapper.map(post, PostDto.class));
            }
        }
        return result;
    }

    @Override
    public List<PostDto> getPostsByTitleContains(String title) {
        var resutl = postRepo.findAll().stream()
                .filter(post -> post.getTitle().contains(title))
                .map(p->modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
        return resutl;
    }
}
