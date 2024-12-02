package view;

import model.ExchangeProgram;
import model.User;

import java.util.List;

public interface View {
    void showMenu();
    void showMessage(String message);
    void displayUsers(List<User> users);
    void displayPrograms(List<ExchangeProgram> programs);
}
