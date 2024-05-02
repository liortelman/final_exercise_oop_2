public class Main {
    public static void main(String[] args) {
        // Create a course registration system
        CourseRegistrationSystem registrationSystem = CourseRegistrationSystem.getInstance();

        // Create new students with passwords
        Student alice = new Student("Alice", 1, true, "alice123");
        Student bob = new Student("Bob", 2, true, "bob456");
        Student lior = new Student("Lior", 3, true, "lior789");
        Student oriya = new Student("Oriya", 4, true, "oriya012");

        // Add students to the system
        registrationSystem.addUser(alice);
        registrationSystem.addUser(bob);
        registrationSystem.addUser(lior);
        registrationSystem.addUser(oriya);

        // Create new lecturers and practitioners
        Lecturer or = new Lecturer("Or", 5, true, "or789", registrationSystem);
        Lecturer liat = new Lecturer("Liat", 6, true, "liat012", registrationSystem);
        Practitioner david = new Practitioner("David", 7, true, "david012", registrationSystem);

        // Add lecturers and practitioners to the system
        registrationSystem.addUser(or);
        registrationSystem.addUser(liat);
        registrationSystem.addUser(david);

        // Create new courses
        CourseFactory factory = new ConcreteCourseFactory();
        Course mathCourse = factory.createCourse("Mathematics", 101, 30, UpdateType.COMPULSORY_COURSE);
        Course physicsCourse = factory.createCourse("Physics", 201, 3, UpdateType.ELECTIVE_COURSE);
        Course literatureCourse = factory.createCourse("Literature", 301, 25, UpdateType.SEMINAR_COURSE);
        Course chemistryCourse = factory.createCourse("Chemistry", 401, 15, UpdateType.ELECTIVE_COURSE);
        Course programmingCourse = factory.createCourse("Programming", 501, 25, UpdateType.COMPULSORY_COURSE);

        // Add courses to the system
        registrationSystem.addCourse(mathCourse);
        registrationSystem.addCourse(physicsCourse);
        registrationSystem.addCourse(literatureCourse);
        registrationSystem.addCourse(chemistryCourse);
        registrationSystem.addCourse(programmingCourse);

        // Add students to courses
        alice.addToCart(mathCourse);
        alice.addToCart(chemistryCourse);
        bob.addToCart(physicsCourse);
        bob.addToCart(literatureCourse);
        lior.addToCart(physicsCourse);
        lior.addToCart(literatureCourse);
        oriya.addToCart(physicsCourse);

        // Checkout courses for students
        alice.getShoppingCart().checkout();
        bob.getShoppingCart().checkout();
        lior.getShoppingCart().checkout();
        oriya.getShoppingCart().checkout();


        // Add new courses by lecturers and practitioner
        or.addNewCourse("OOP_a", 401, 40, UpdateType.COMPULSORY_COURSE);
        liat.addNewCourse("OOP_b", 402, 41, UpdateType.COMPULSORY_COURSE);
        david.addNewCourse("OOP_c", 403, 20, UpdateType.ELECTIVE_COURSE);


        // Display the courses enrolled by each student
        System.out.println("\n");
        System.out.println("Courses enrolled by Alice:\n" + alice.getCourses());
        System.out.println("Courses enrolled by Bob:\n" + bob.getCourses());

        // Display the registered students for each course
        System.out.println("\n");
        System.out.println("Registered students for Mathematics:\n" + mathCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Physics:\n" + physicsCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Literature:\n" + literatureCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Chemistry:\n" + chemistryCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Programming:\n" + programmingCourse.getRegisteredStudentsInfo());

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

        // Try to register Alice to a full course (should fail)
        alice.addToCart(physicsCourse);
        alice.getShoppingCart().checkout();

        // Display the waiting list for a specific course
        System.out.println("Waiting list for Physics course:\n" + physicsCourse.getWaitingList());

    }
}
