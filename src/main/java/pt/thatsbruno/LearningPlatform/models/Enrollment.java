package pt.thatsbruno.LearningPlatform.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Setter
@Getter
@Entity
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

    // Constructors
    public Enrollment() {}

    public Enrollment(User user, Course course, LocalDate enrollmentDate) {
        this.user = user;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.progress = 0.0;  // Initialize progress to 0%
        this.completed = false;
    }

}

