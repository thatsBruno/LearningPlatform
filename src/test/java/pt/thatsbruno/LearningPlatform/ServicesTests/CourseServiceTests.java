package pt.thatsbruno.LearningPlatform.ServicesTests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.thatsbruno.LearningPlatform.Repositories.CourseRepository;
import pt.thatsbruno.LearningPlatform.Services.CourseService;
import pt.thatsbruno.LearningPlatform.models.Course;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTests {

    @Mock
    private CourseRepository courseRepository;  // Mocking CourseRepository

    @InjectMocks
    private CourseService courseService;  // Injecting mock into CourseService

    private Course course1;
    private Course course2;

    @BeforeEach
    public void setUp() {
        // Create some sample Course objects
        course1 = new Course();
        course1.setId(1L);
        course2 = new Course();
        course2.setId(2L);
    }

    @Test
    public void testGetAllCourses() {
        // Arrange: Set up the mock behavior
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        // Act: Call the method to test
        List<Course> courses = courseService.getAllCourses();

        // Assert: Verify the results
        assertNotNull(courses);
        assertEquals(2, courses.size());
        assertEquals(1, courses.get(0).getId());
        assertEquals(2, courses.get(1).getId());
        verify(courseRepository, times(1)).findAll();  // Verify that findAll() was called once
    }

    @Test
    public void testCreateCourse() {
        // Arrange: Set up the mock behavior
        when(courseRepository.save(course1)).thenReturn(course1);

        // Act: Call the method to test
        Course createdCourse = courseService.createCourse(course1);

        // Assert: Verify the results
        assertNotNull(createdCourse);
        assertEquals(1, createdCourse.getId());
        verify(courseRepository, times(1)).save(course1);  // Verify that save() was called once
    }
}

