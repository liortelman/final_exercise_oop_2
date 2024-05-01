/**
 * Class representing a elective course.
 * Extends the abstract class Course
 **/
import java.util.List;

// Concrete subclass representing elective course
class ElectiveCourse extends Course {
    public ElectiveCourse(String name, int courseNumber, int maxUsers) {
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
        return "Elective";
    }

    @Override
    public String toString() {
        return "ElectiveCourse: name= " + name + ", courseNumber=" + courseNumber + "";
    }
}