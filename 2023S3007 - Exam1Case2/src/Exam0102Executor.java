import java.util.Scanner;

public class Exam0102Executor {
    public static void main(String[] args) {
        Exam0102Controller controller = new Exam0102Controller();
        controller.readData();
        controller.showData();
        controller.addData();
        controller.editData();
        controller.deleteData();
    }
}