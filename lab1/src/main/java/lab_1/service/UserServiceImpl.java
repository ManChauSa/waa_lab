package lab_1.service;

import lab_1.entity.User;
import lab_1.entity.dto.response.PostDto;
import lab_1.entity.dto.response.UserDto;
import lab_1.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{

    UserRepo userRepo;
    PostService postService;

    UserServiceImpl(UserRepo userRepo, PostService postService){
        this.userRepo = userRepo;
        this.postService = postService;
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
    public List<UserDto> getUsersHaveMoreOnePost() {
        var result = new ArrayList<UserDto>();
        var listUsers = userRepo.findAll();
        for (var user : listUsers) {
            if (user.getPosts().size() > 1) {
                result.add(modelMapper.map(user, UserDto.class));
            }
        }
        return result;
    }
}
