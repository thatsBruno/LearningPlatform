package pt.thatsbruno.LearningPlatform.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.thatsbruno.LearningPlatform.models.Course;
import pt.thatsbruno.LearningPlatform.models.Lesson;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    // Find all lessons for a specific course
    List<Lesson> findByCourse(Course course);
}

