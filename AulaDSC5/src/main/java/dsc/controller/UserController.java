package dsc.controller;

import java.util.List;

import dsc.model.User;
import dsc.services.UserService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UserController {
    @EJB
    private UserService userService;

    private String username;
    private String password;

    public void addUser() {
        User user = new User(username, password);
        userService.addUser(user);
    }

    public void removeUser() {
        userService.removeUser(username);
    }

    public void updateUser() {
        User user = new User(username, password);
        userService.updateUser(user);
    }

    public User findUser() {
        return userService.findUser(username);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Getters e setters para username e password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
