package lab_1.controller;

import lab_1.entity.dto.response.PostDto;
import lab_1.entity.dto.response.UserDto;
import lab_1.repo.UserRepo;
import lab_1.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDto param){
        userService.saveUser(param);
    }

    @GetMapping("/{userId}/post")
    public List<PostDto> getPostsByUserId(@PathVariable("userId") int userId){
        return userService.getPostsByUser(userId);
    }

    @GetMapping("/filter/{number}")
    public List<UserDto> getUsersHaveMoreThanPost(@PathVariable("number")  int number){
        return userService.getUsersHaveMoreThanPost(number);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @GetMapping("/post")
    public List<UserDto> findUsersByPostTitle(@RequestBody String title){
            return  userService.getUsersOfPostByTitle(title);
    }
}
