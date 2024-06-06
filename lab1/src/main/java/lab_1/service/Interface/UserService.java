package lab_1.service.Interface;


import lab_1.entity.dto.response.PostDto;
import lab_1.entity.dto.response.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUser();
    UserDto getUserById(int id);
    void saveUser(UserDto userDto);
    List<PostDto> getPostsByUser(int id);
    void deleteUser(int id);
    List<UserDto> getUsersHaveMoreThanPost(int number);
    List<UserDto> getUsersOfPostByTitle(String title);
}
