import Controller.MovieController;
import View.MovieView;

public class Main {
    public static void main(String[] args) {
        MovieController controller = new MovieController();
        MovieView view = new MovieView(controller);
        view.showMenu();
    }
}
