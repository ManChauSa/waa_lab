package lab_1.repo;

import lab_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("SELECT DISTINCT u FROM User u JOIN u.posts p WHERE p.title = :title")
    List<User> findUsersByPostTitle(@Param("title") String title);

    User findByUsername(String username);

    User findByEmail(String email);
}
