/**
 * Class representing a compulsory course.
 * Extends the abstract class Course
 **/
import java.util.List;

// Concrete subclass representing compulsory course
class CompulsoryCourse extends Course {
    public CompulsoryCourse(String name, int courseNumber, int maxUsers) {
        super(name, courseNumber, maxUsers);
    }

    @Override
    String getCourseName() {
        return super.name;
    }

    @Override
    int getCourseNumber() {
        return super.courseNumber;
    }

    @Override
    int getMaxStudents() {
        return super.maxStudents;
    }

    @Override
    int getCurrentRegisters() {
        return super.currentRegisters;
    }

    @Override
    List<User> getRegisteredStudents() {
        return super.registers;
    }

    @Override
    String getCourseType() {
        return "Compulsory";
    }

    @Override
    public String toString() {
        return "CompulsoryCourse: name= " + name + ", courseNumber=" + courseNumber;
    }
}