package app;

import controller.UserController;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        new LoginView(userController);
    }
}
