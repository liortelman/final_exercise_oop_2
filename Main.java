public class Main {
    public static void main(String[] args) {
        // Create a course registration system
        CourseRegistrationSystem registrationSystem = CourseRegistrationSystem.getInstance();

        // Create some students with passwords
        Student alice = new Student("Alice", 1, true, "alice123");
        Student bob = new Student("Bob", 2, true, "bob456");

        // Add students to the system
        registrationSystem.addUser(alice);
        registrationSystem.addUser(bob);

        // Create some lecturers and practitioners
        Lecturer or = new Lecturer("Or", 3, true, "or789", registrationSystem);
        Lecturer liat = new Lecturer("Liat", 4, true, "liat012", registrationSystem);
        Practitioner david = new Practitioner("David", 4, true, "david012", registrationSystem);

        // Add lecturers and practitioners to the system
        registrationSystem.addUser(or);
        registrationSystem.addUser(liat);
        registrationSystem.addUser(david);

        // Create some courses
        CourseFactory factory = new ConcreteCourseFactory();
        Course mathCourse = factory.createCourse("Mathematics", 101, 30, UpdateType.COMPULSORY_COURSE);
        Course physicsCourse = factory.createCourse("Physics", 201, 20, UpdateType.ELECTIVE_COURSE);
        Course literatureCourse = factory.createCourse("Literature", 301, 25, UpdateType.SEMINAR_COURSE);

        // Add courses to the system
        registrationSystem.addCourse(mathCourse);
        registrationSystem.addCourse(physicsCourse);
        registrationSystem.addCourse(literatureCourse);

        // Add course observers (students) to courses
        registrationSystem.registerObserverToCourse(new StudentObserver(), mathCourse);
        registrationSystem.registerObserverToCourse(new StudentObserver(), physicsCourse);
        registrationSystem.registerObserverToCourse(new StudentObserver(), literatureCourse);

        // Student Alice adds courses to their cart
        alice.addToCart(mathCourse);
        alice.addToCart(physicsCourse);

        // Student Bob adds courses to their cart
        bob.addToCart(physicsCourse);
        bob.addToCart(literatureCourse);

        // Student Alice checks out their courses
        alice.getShoppingCart().checkout();

        // Student Bob checks out their courses
        bob.getShoppingCart().checkout();

        // Lecturer Or adds a new course
        or.addNewCourse("OOP_a", 401, 40, UpdateType.COMPULSORY_COURSE);

        // Lecturer Or adds a new course
        or.addNewCourse("OOP_b", 401, 41, UpdateType.COMPULSORY_COURSE);

        // Practitioner David adds a new course
        david.addNewCourse("Programming", 501, 20, UpdateType.ELECTIVE_COURSE);

        // Display the courses enrolled by each student
        System.out.println("Courses enrolled by Alice:\n" + alice.getCourses());
        System.out.println("Courses enrolled by Bob:\n" + bob.getCourses());

        // Display the registered students for each course
        System.out.println("Registered students for Mathematics:\n" + mathCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Physics:\n" + physicsCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Literature:\n" + literatureCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Chemistry:\n" + registrationSystem.getAllCourses().get(3).getRegisteredStudentsInfo());
        System.out.println("Registered students for Programming:\n" + registrationSystem.getAllCourses().get(4).getRegisteredStudentsInfo());

        // Additional checks for lecturers and practitioners - should fail
        System.out.println("\nAdditional checks (should fail):");

        // Lecturer Or adds the same course again (should fail)
        or.addNewCourse("OOP_a", 401, 40, UpdateType.COMPULSORY_COURSE);

        // Lecturer Liat adds a new course with negative max students (should fail)
        liat.addNewCourse("OOP_b", 201, -10, UpdateType.ELECTIVE_COURSE);

        // Practitioner David adds a new course with the same name and number as an existing course (should fail)
        david.addNewCourse("Physics", 201, 20, UpdateType.ELECTIVE_COURSE);

        // Practitioner David tries to add a new course without being logged in (should fail)
        david.logout();
        david.addNewCourse("Biology", 601, 15, UpdateType.SEMINAR_COURSE);
    }
}
