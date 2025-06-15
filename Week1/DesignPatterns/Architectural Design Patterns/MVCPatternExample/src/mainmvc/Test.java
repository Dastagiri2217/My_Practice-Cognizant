package mainmvc;
public class Test {
    public static void main(String[] args) {
        // Model
        Student student = new Student("Dastagiri", "229X1A3233", "A");

        //View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        // initial data
        controller.updateView();

        // Update model data using controller
        controller.setStudentName("Dastagiri Dudekula");
        controller.setStudentGrade("A+");

        // updated data
        controller.updateView();
    }
}
