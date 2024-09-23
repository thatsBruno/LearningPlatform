package pt.thatsbruno.LearningPlatform.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.thatsbruno.LearningPlatform.models.Course;
import pt.thatsbruno.LearningPlatform.models.User;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Find all courses created by a specific instructor
    List<Course> findByInstructor(User instructor);

    // Search for courses by title
    List<Course> findByTitleContaining(String title);
}