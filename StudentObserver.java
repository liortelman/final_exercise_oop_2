/**
 * Concrete implementation of the observer interface.
 * Observes available spots in courses and notifies students.
 **/
import java.util.List;

class StudentObserver implements CourseObserver {

    // Implementation of notifyCourseAvailable method
    @Override
    public void notifyCourseAvailable(Course course) {
        System.out.println("A place has become available in the course " + course.getCourseName());
    }
}