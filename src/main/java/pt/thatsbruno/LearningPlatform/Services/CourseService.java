package pt.thatsbruno.LearningPlatform.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.thatsbruno.LearningPlatform.Repositories.CourseRepository;
import pt.thatsbruno.LearningPlatform.models.Course;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }
}
