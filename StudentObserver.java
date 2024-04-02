import java.util.List;

// Concrete implementation of the observer interface
class StudentObserver implements CourseObserver {

    // Implementation of notifyCourseAvailable method
    @Override
    public void notifyCourseAvailable(Course course) {
        System.out.println("A place has become available in the course " + course.getCourseName());
    }
}