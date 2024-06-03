package lab_1.repo;

import lab_1.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger,Integer> {
}
