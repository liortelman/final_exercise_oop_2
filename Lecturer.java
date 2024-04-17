class Lecturer extends User {

    private CourseRegistrationSystem registrationSystem;

    public Lecturer(String name, int id, boolean loggedIn, CourseRegistrationSystem registrationSystem){
        super(name, id, loggedIn);
        this.registrationSystem = registrationSystem;
    }

    public void addNewCourse(String name, int id, int maxStudents, UpdateType updateType){
        // Check if the user is logged in
        if (isLoggedIn()) {
            // Check if a course with the same name and number already exists
            if (!registrationSystem.isCourseExists(name, id)) {
                CourseFactory factory = new ConcreteCourseFactory(); // Create a concrete course factory
                Course newCourse = factory.createCourse(name, id, maxStudents, updateType); // Create the course using the factory
                registrationSystem.addCourse(newCourse); // Add the course to the system
            } else {
                System.out.println("Course with the same name and number already exists.");
            }
        } else {
            System.out.println("User is not logged in.");
        }
    }
}
