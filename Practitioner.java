/**
 * Represents a practitioner.
 * Extends User class.
 **/
public class Practitioner extends User {

    private CourseRegistrationSystem registrationSystem;

    public Practitioner(String name, int id, boolean loggedIn, String password, CourseRegistrationSystem registrationSystem) {
        super(name, id, loggedIn, password);
        this.registrationSystem = registrationSystem;
    }

    public void addNewCourse(String name, int id, int maxStudents, UpdateType updateType) {
        // Check if the user is logged in
        if (isLoggedIn()) {
            // Check if a course with the same name and number already exists
            if (!registrationSystem.isCourseExists(name, id)) {
                // Additional check for course details
                if (maxStudents > 0) {
                    // Create a concrete course factory
                    CourseFactory factory = new ConcreteCourseFactory();
                    // Create the course using the factory
                    Course newCourse = factory.createCourse(name, id, maxStudents, updateType);
                    // Add the course to the system
                    registrationSystem.addCourse(newCourse);
                    System.out.println("Course " + name + " added successfully by " + getName());
                } else {
                    System.out.println("Max students must be a positive number.");
                }
            } else {
                System.out.println("Course with the same name and number already exists.");
            }
        } else {
            System.out.println("User is not logged in.");
        }
    }
}
