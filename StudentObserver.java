/**
 * Concrete implementation of the observer interface.
 * Observes available spots in courses and notifies students.
 **/
import java.util.List;

class StudentObserver implements CourseObserver {

    // Implementation of notifyCourseAvailable method
    @Override
    public void notifyCourseAvailable(Course course) {
        List<User> waitingList = course.getWaitingList(); // Get the waiting list of the course
        for (User student : waitingList) {
            if (student instanceof Student) { // Check if the user is a student
                System.out.println("A place has become available in the course " + course.getCourseName() + " for student " + student.getName());
            }
        }
    }
}