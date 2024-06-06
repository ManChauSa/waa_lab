package lab_1.service;

import lab_1.entity.User;
import lab_1.entity.dto.response.PostDto;
import lab_1.entity.dto.response.UserDto;
import lab_1.repo.CommentRepo;
import lab_1.repo.PostRepo;
import lab_1.repo.UserRepo;
import lab_1.service.Interface.CommentService;
import lab_1.service.Interface.PostService;
import lab_1.service.Interface.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;
    PostService postService;
    CommentService commentService;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;

    UserServiceImpl(UserRepo userRepo, PostService postService, CommentService commentService){
        this.userRepo = userRepo;
        this.postService = postService;
        this.commentService = commentService;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUser() {
        var result = userRepo.findAll();
        return result.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int id){
        return modelMapper.map(userRepo.findById(id),UserDto.class);
    }

    @Override
    public void saveUser(UserDto param) {
        userRepo.save(modelMapper.map(param, User.class));
    }

    @Override
    public List<PostDto> getPostsByUser(int id) {
        var result = userRepo.findById(id).get().getPosts();
        return result.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int id) {
        var user = userRepo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
        user.getPosts().forEach(p->{
            p.getComments().forEach(c->commentRepo.deleteById((int)c.getId()));
            postRepo.deleteById((int) p.getId());
        });
        userRepo.deleteById(id);
    }

    @Override
    public List<UserDto> getUsersHaveMoreThanPost(int number) {
        var result = new ArrayList<UserDto>();
        var listUsers = userRepo.findAll();
        for (var user : listUsers) {
            if (user.getPosts().size() > number) {
                result.add(modelMapper.map(user, UserDto.class));
            }
        }
        return result;
    }

    @Override
    public List<UserDto> getUsersOfPostByTitle(String title) {
        return List.of();
    }
}
