import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class managing the shopping cart of a student
class ShoppingCart {
    private List<Course> coursesCart;
    protected Student currentUser; // Assuming this is the current logged-in user

    public ShoppingCart(Student currentUser) {
        this.coursesCart = new ArrayList<>();
        this.currentUser = currentUser;
    }

    public void addCourse(Course course) {
        // Check if there is space available in the course
        if (!course.isFull()) {
            // Check if the course is already in the cart
            if (!(coursesCart.contains(course))) {
                coursesCart.add(course);
            } else {
                System.out.println("Course is already in the shopping cart.");
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("This course is full. If you would like to be notified when a space becomes available, please enter 1");
            int alart = scanner.nextInt();
            if (alart == 1) {
                course.addStudentToWaitingList(currentUser); // Add student to waiting list so that he will receive a notification if a place becomes available
            }
        }
    }

    public void removeCourse(Course course) {
        // Check if the course is in the cart
        if (coursesCart.contains(course)) {
            coursesCart.remove(course);
        } else {
            System.out.println("Course is not in the shopping cart.");
        }
    }

    public void checkout(){
        for (Course course: coursesCart){
            course.addStudent(currentUser);
            currentUser.addCourseToList(course);
        }
        coursesCart.clear(); // Empty the shopping cart after checkout
    }


}