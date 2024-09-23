package pt.thatsbruno.LearningPlatform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    public Course(Long id, User instructor, String description, String title) {
        this.id = id;
        this.instructor = instructor;
        this.description = description;
        this.title = title;
    }

    @ManyToOne
    private User instructor;

}
