package lab_1.repo;

import lab_1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
}
