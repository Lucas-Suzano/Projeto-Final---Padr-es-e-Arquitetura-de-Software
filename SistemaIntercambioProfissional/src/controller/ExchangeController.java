package controller;

import factory.ExchangeProgramFactory;
import model.*;
import observer.ProgramObserver;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExchangeController {
    private final List<User> users;
    private final List<ExchangeProgram> programs;
    private final View view;
    private final ProgramObserver programObserver;

    public ExchangeController(View view) {
        this.users = new ArrayList<>();
        this.programs = new ArrayList<>();
        this.view = view;
        this.programObserver = new ProgramObserver();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerUser(scanner);
                case 2 -> registerProgram(scanner);
                case 3 -> view.displayUsers(users);
                case 4 -> displayProgramsWithCost();
                case 5 -> {
                    view.showMessage("Exiting... Goodbye!");
                    return;
                }
                default -> view.showMessage("Invalid option. Try again.");
            }
        }
    }

    private void registerUser(Scanner scanner) {
        view.showMessage("Enter user name:");
        String name = scanner.nextLine();

        view.showMessage("Enter user age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        view.showMessage("Enter user country:");
        String country = scanner.nextLine();

        users.add(new User(name, age, country));
        view.showMessage("User registered successfully!");
    }

    private void registerProgram(Scanner scanner) {
        view.showMessage("Enter program type (Work/Travel):");
        String type = scanner.nextLine();

        view.showMessage("Enter program name:");
        String name = scanner.nextLine();

        view.showMessage("Enter destination country:");
        String country = scanner.nextLine();

        view.showMessage("Enter duration in weeks:");
        int duration = scanner.nextInt();
        scanner.nextLine();

        view.showMessage("Choose cost strategy: (1) Simple or (2) Complex");
        int strategyChoice = scanner.nextInt();
        scanner.nextLine();

        CostCalculationStrategy strategy = switch (strategyChoice) {
            case 1 -> new SimpleCostStrategy();
            case 2 -> new ComplexCostStrategy();
            default -> {
                view.showMessage("Invalid strategy. Defaulting to Simple.");
                yield new SimpleCostStrategy();
            }
        };

        ExchangeProgram program = ExchangeProgramFactory.createProgram(type, name, country, duration, strategy);

        programs.add(program);
        programObserver.notifyObservers("New program registered: " + program);
        view.showMessage("Exchange program registered successfully!");
    }

    private void displayProgramsWithCost() {
        view.showMessage("\nAvailable Exchange Programs with Costs:");
        for (ExchangeProgram program : programs) {
            double cost = program.calculateCost();
            view.showMessage(program.toString() + String.format(", Cost: $%.2f", cost));
        }
    }
}
