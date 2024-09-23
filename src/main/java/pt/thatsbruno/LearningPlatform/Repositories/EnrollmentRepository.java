package pt.thatsbruno.LearningPlatform.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.thatsbruno.LearningPlatform.models.Course;
import pt.thatsbruno.LearningPlatform.models.Enrollment;
import pt.thatsbruno.LearningPlatform.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findByUserAndCourse(User user, Course course);
    List<Enrollment> findByUser(User user);
    List<Enrollment> findByCourse(Course course);
}

