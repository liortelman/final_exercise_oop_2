// Concrete subclasses of User
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
                switch (updateType) {
                    case SEMINAR_COURSE:
                        Course s_course = new SeminarCourse(name, id, maxStudents);
                        registrationSystem.addCourse(s_course);
                        break;
                    case ELECTIVE_COURSE:
                        Course e_course = new ElectiveCourse(name, id, maxStudents);
                        registrationSystem.addCourse(e_course);
                        break;
                    case COMPULSORY_COURSE:
                        Course c_course = new CompulsoryCourse(name, id, maxStudents);
                        registrationSystem.addCourse(c_course);
                        break;
                }
            } else {
                System.out.println("Course with the same name and number already exists.");
            }
        } else {
            System.out.println("User is not logged in.");
        }
    }
    // Additional properties and methods specific to Lecturer
}