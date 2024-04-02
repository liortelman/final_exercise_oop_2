import java.util.ArrayList;
import java.util.List;

// Singleton class representing the course registration system
class CourseRegistrationSystem {
    private static CourseRegistrationSystem instance;
    private static final int MAX_ACTIVE_USERS = 100;
    private List<Course> courses;
    private List<User> users;

    // Private constructor to prevent external instantiation
    private CourseRegistrationSystem() {
        // Initialize the lists of courses and users
        courses = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Method to obtain the singleton instance of "Course Registration System"
    public static synchronized CourseRegistrationSystem getInstance() {
        if (instance == null) {
            instance = new CourseRegistrationSystem();  // Create a new instance if one doesn't exist
            // Check if the maximum number of active users has been reached
        } else if (instance.countActiveUsers() >= MAX_ACTIVE_USERS) {
            throw new IllegalStateException("Maximum number of active users reached. Cannot create more instances of CourseRegistrationSystem.");
        }
        return instance;
    }

    // Method to count the number of active users in the system
    private int countActiveUsers() {
        int activeUsers = 0;
        for (User user : users) {
            // Assume that a user is considered active if they are currently logged in
            if (user.isLoggedIn()) {
                activeUsers++;
            }
        }
        return activeUsers;
    }

    // Method to add new user - for students
    public void addUser(User user) {
        users.add(user); // Update the user list in the registration system
    }

    // Method to remove a user - for students
    public void removeUser(User user) {
        users.remove(user); // Update the user list in the registration system

    }

    // Method to add new course - for lecturers or practitioners
    public void addCourse(Course course){
        courses.add(course); // Update the course list in the registration system

    }

    // Method to remove a course - for lecturers or practitioners
    public void removeCourse(Course course){
        courses.remove(course); // Update the course list in the registration system
    }

    // Method to register a student observer to a course
    public void registerObserverToCourse(StudentObserver observer, Course course) {
        course.addObserver(observer);
    }

    // Method to return the list of courses
    public List<Course> getCourses() {
        return courses;
    }

    // Method to check if a course with the same name and number already exists
    public boolean isCourseExists(String name, int courseNumber) {
        for (Course course : courses) {
            if (course.getCourseName().equals(name) && course.getCourseNumber() == courseNumber) {
                return true; // Course with the same name and number already exists
            }
        }
        return false; // Course with the same name and number doesn't exist
    }

    public List<Course> getAllCourses() {
        return this.courses;
    }

    // Additional methods for managing courses and users
}