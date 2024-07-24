package view;

import controller.RecipeController;
import controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    private UserController userController;
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginView(UserController userController) {
        this.userController = userController;
        frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 30, 80, 25);
        frame.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 30, 160, 25);
        frame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 65, 80, 25);
        frame.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 65, 160, 25);
        frame.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(20, 100, 80, 25);
        frame.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(180, 100, 80, 25);
        frame.add(registerButton);

        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (userController.login(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                    frame.dispose();
                    new RecipeView(new RecipeController()); // Pass RecipeController here
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (userController.register(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Registration successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Registration failed.");
                }
            }
        });
    }
}
