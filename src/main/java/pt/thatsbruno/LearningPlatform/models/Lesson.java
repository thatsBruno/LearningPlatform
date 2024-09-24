package pt.thatsbruno.LearningPlatform.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="lessonTbl")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contentUrl;  // URL for video or content
    private String description;

    @ManyToOne
    private Course course;
}
