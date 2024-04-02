import java.util.List;

// Concrete subclass representing a seminar course
class SeminarCourse extends Course {
    public SeminarCourse(String name, int courseNumber, int maxUsers) {
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
        return "Seminar";
    }

    @Override
    public String toString() {
        return "SeminarCourse name= " + name + ", courseNumber=" + courseNumber;
    }
}