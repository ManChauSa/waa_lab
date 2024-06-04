package lab_1.repo;

import lab_1.entity.ExceptionLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionLoggerRepo extends JpaRepository<ExceptionLogger, Integer> {
}
