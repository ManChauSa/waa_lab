package lab_1.repo;

import lab_1.entity.Student;
import lab_1.entity.dto.response.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query("SELECT sc.courseId FROM StudentCourse sc WHERE sc.studentId = :studentId ")
    List<CourseDto> findAllCourseOfStudentById(@Param("studentId") int studentId);
}
