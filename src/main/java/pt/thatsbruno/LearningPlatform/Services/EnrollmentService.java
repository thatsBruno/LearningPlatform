package pt.thatsbruno.LearningPlatform.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.thatsbruno.LearningPlatform.Repositories.CourseRepository;
import pt.thatsbruno.LearningPlatform.Repositories.EnrollmentRepository;
import pt.thatsbruno.LearningPlatform.Repositories.UserRepository;
import pt.thatsbruno.LearningPlatform.models.Course;
import pt.thatsbruno.LearningPlatform.models.Enrollment;
import pt.thatsbruno.LearningPlatform.models.User;

import java.time.LocalDate;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void enrollUserInCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment(user, course, LocalDate.now());
        enrollmentRepository.save(enrollment);
    }

    public void updateCourseProgress(Long enrollmentId, Double progress) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        enrollment.setProgress(progress);

        if (progress >= 100) {
            enrollment.setCompleted(true);
        }

        enrollmentRepository.save(enrollment);
    }
}

