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
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contentUrl;  // URL for video or content
    private String description;

    public Lesson(Long id, Course course, String description, String contentUrl, String title) {
        this.id = id;
        this.course = course;
        this.description = description;
        this.contentUrl = contentUrl;
        this.title = title;
    }

    @ManyToOne
    private Course course;
}
