import controller.ExchangeController;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        ExchangeController controller = new ExchangeController(view);
        controller.start();
    }
}
