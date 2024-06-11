package lab_1.service;


import lab_1.entity.Post;
import lab_1.entity.User;
import lab_1.entity.dto.response.PostDto;
import lab_1.entity.dto.response.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUser();
    UserDto getUserById(int id);
    void saveUser(UserDto userDto);
    List<PostDto> getPostsByUser(int id);
    List<UserDto> getUsersHaveMoreOnePost();

}
