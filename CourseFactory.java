/**
 * Abstract class representing a course factory.
 * Defines the contract for creating different types of courses.
 **/

abstract class CourseFactory {
    abstract Course createCourse(String name, int courseNumber, int maxUsers, UpdateType updateType);
}

// Concrete implementation of CourseFactory for creating different types of courses
class ConcreteCourseFactory extends CourseFactory {
    @Override
    Course createCourse(String name, int courseNumber, int maxStudents, UpdateType updateType) {
        switch (updateType) {
            case SEMINAR_COURSE:
                return new SeminarCourse(name, courseNumber, maxStudents);
            case ELECTIVE_COURSE:
                return new ElectiveCourse(name, courseNumber, maxStudents);
            case COMPULSORY_COURSE:
                return new CompulsoryCourse(name, courseNumber, maxStudents);
            default:
                throw new IllegalArgumentException("Invalid course type: " + updateType);
        }
    }
}




