package view;

import model.ExchangeProgram;
import model.User;

import java.util.List;

public class ConsoleView implements View {
    @Override
    public void showMenu() {
        System.out.println("=== Exchange Program System ===");
        System.out.println("1. Register User");
        System.out.println("2. Register Exchange Program");
        System.out.println("3. List Users");
        System.out.println("4. List Programs");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayUsers(List<User> users) {
        System.out.println("\nRegistered Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public void displayPrograms(List<ExchangeProgram> programs) {
        System.out.println("\nAvailable Exchange Programs:");
        for (ExchangeProgram program : programs) {
            System.out.println(program);
        }
    }
}
