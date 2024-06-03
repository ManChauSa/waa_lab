package lab_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer descriptionId;
    private  String courseDescription;
    private  String program;
    private  Integer lastUpdate;
    private  Integer credit;

    @OneToOne
    @JoinColumn(name = "course_id")
    private  Course course;
}
