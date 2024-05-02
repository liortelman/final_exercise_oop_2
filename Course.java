/**
 * Abstract class representing a course in the system.
 **/
import java.util.List;
import java.util.ArrayList;

// Abstract class representing a course
abstract class Course {
    protected String name;
    protected int courseNumber;
    protected int maxStudents;
    protected List<User> registers = new ArrayList<>();
    protected int currentRegisters = registers.size();
    protected List<User> waitingList = new ArrayList<>();

    // Constructor
    public Course(String name, int courseNumber, int maxStudents) {
        this.name = name;
        this.courseNumber = courseNumber;
        this.maxStudents = maxStudents;
    }

    // List to hold observers
    private List<CourseObserver> observers = new ArrayList<>();

    // This method registers an observer for the course
    public void addObserver(CourseObserver observer) {
        observers.add(observer);
    }

    // This method removes an observer from the course
    public void removeObserver(CourseObserver observer) {
        observers.remove(observer);
    }

    // This method notifies observers when spots become available in the course
    public void notifyObservers() {
        for (CourseObserver observer : observers) {
            observer.notifyCourseAvailable(this);
        }
    }

    // Abstract method to get the course name
    abstract String getCourseName();

    // Abstract method to get the course number
    abstract int getCourseNumber();

    // Abstract method to get the maximum number of students allowed
    abstract int getMaxStudents();

    // Abstract method to get the current number of registered students
    abstract int getCurrentRegisters();

    // Abstract method to get the list of registered students
    abstract List<User> getRegisteredStudents();

    // Abstract method to get the type of the course
    abstract String getCourseType();

    // This method checks if the course has reached its maximum capacity
    public boolean isFull(){
        return registers.size() >= maxStudents;
    }

    // This method adds a student to the course if there is space available
    public void addStudent(User user){
            registers.add(user);
            currentRegisters++;
            notifyObservers();
    }

    // This method removes a student from the course
    public void removeStudent(User user) {
        if (registers.contains(user)) {
            registers.remove(user);
            currentRegisters--;
            notifyObservers();

            // Check if there are students in the waiting list
            for (User waitingUser : waitingList) {
                if (waitingUser instanceof CourseObserver) {
                    ((CourseObserver) waitingUser).notifyCourseAvailable(this);
                }
            }

            // Clear the waiting list as spots have become available
            waitingList.clear();
        }
    }

    // This method adds a student to the waiting list
    public void addStudentToWaitingList(User currentUser) {
        waitingList.add(currentUser);
    }

    // This method removes a student from the waiting list
    public void removeStudentFromWaitingList(Student currentUser) {
        waitingList.remove(currentUser);
    }

    public List<User> getWaitingList() {
        return waitingList;
    }

    // This method generates a string containing information about the registered students for the course
    public String getRegisteredStudentsInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registered students for ").append(name).append(" (Max: ").append(maxStudents).append("):\n");
        for (User student : registers) {
            sb.append(student.toString()).append("\n");
        }
        return sb.toString();
    }

    // This method generates a string representation of the course
    @Override
    public String toString() {
        return getCourseType() + " Course: " + name + ", courseNumber=" + courseNumber;
    }



}