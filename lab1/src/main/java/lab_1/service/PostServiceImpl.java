package lab_1.service;

import lab_1.entity.Post;
import lab_1.entity.dto.response.PostDto;
import lab_1.helper.ListMapper;
import lab_1.repo.PostRepo;
import lab_1.repo.PostRepoImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;
    @Override
    public List<Post> getAll() {
        return postRepo.getAll();
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(postRepo.getbyId(id),PostDto.class);
    }

    @Override
    public void add(PostDto param) {
         postRepo.add(modelMapper.map(param, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(int id, PostDto p) {
        postRepo.update(id,modelMapper.map(p,Post.class));
    }

    @Override
    public List<PostDto> getbyAuthor(String author) {
        List<PostDto> result = new ArrayList<PostDto>();
        result = listMapper.mapList(postRepo.getbyAuthor(author),new PostDto());
        return result;
    }

    @Override
    public List<PostDto> getbyAuthorContains(String text) {
        List<PostDto> result = new ArrayList<PostDto>();
        result = listMapper.mapList(postRepo.getbyAuthorContains(text),new PostDto());
        return result;
//        return (List<PostDto>) listMapper.mapList(postRepo.getbyAuthor(text),new PostDto());
    }

}
