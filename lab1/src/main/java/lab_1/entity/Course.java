package lab_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    private Integer courseId;
    private String name;

    @OneToMany
    @JoinColumn(name = "course_id")
    private List<Student> students;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private  CourseDetail courseDetail;

}
