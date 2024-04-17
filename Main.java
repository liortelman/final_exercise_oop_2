public class Main {
    public static void main(String[] args) {
        // Create a course registration system
        CourseRegistrationSystem registrationSystem = CourseRegistrationSystem.getInstance();

        // Create some students
        Student alice = new Student("Alice", 1, true);
        Student bob = new Student("Bob", 2, true);

        // Add students to the system
        registrationSystem.addUser(alice);
        registrationSystem.addUser(bob);

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

        // Display the courses enrolled by each student
        System.out.println("Courses enrolled by Alice:\n" + alice.getCourses());
        System.out.println("Courses enrolled by Bob:\n" + bob.getCourses());

        // Display the registered students for each course
        System.out.println("Registered students for Mathematics:\n" + mathCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Physics:\n" + physicsCourse.getRegisteredStudentsInfo());
        System.out.println("Registered students for Literature:\n" + literatureCourse.getRegisteredStudentsInfo());
    }
}
