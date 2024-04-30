import java.util.ArrayList;
import java.util.List;

class Student extends User {
    private ShoppingCart shoppingCart;
    private List<Course> courses;

    public Student(String name, int id, boolean loggedIn, String password) {
        super(name, id, loggedIn, password);
        this.shoppingCart = new ShoppingCart(this);
        this.courses = new ArrayList<>();
    }

    public void addCourseToList(Course course){
        courses.add(course);
    }

    public void removeCourseFromList(Course course){
        courses.remove(course);
        course.removeStudent(this);
    }
    public void addToCart(Course course) {
        shoppingCart.addCourse(course);
        // Add course to the shopping cart
    }

    public void removeFromCart(Course course) {
        shoppingCart.removeCourse(course);
        // Remove course from the shopping cart
    }

    public ShoppingCart getShoppingCart(){
        return this.shoppingCart;
    }

    public List<Course> getCourses(){
        return this.courses;
    }

    @Override
    public String toString() {
        return "Student: " + getName();
    }

}