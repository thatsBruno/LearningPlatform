package pt.thatsbruno.LearningPlatform.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="enrollmentTbl")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private LocalDate enrollmentDate;
    private Double progress;  // Progress in percentage, e.g., 75.0
    private Boolean completed;  // Has the user completed the course?

    public Enrollment(User user, Course course, LocalDate now) {
        this.user = user;
        this.course = course;
        this.enrollmentDate = now;
    }
}

