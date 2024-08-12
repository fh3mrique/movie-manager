package dsc.services;

import java.util.ArrayList;
import java.util.List;

import dsc.model.User;
import jakarta.ejb.Stateless;

@Stateless
public class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }

    public void updateUser(User updatedUser) {
        for (User user : users) {
            if (user.getUsername().equals(updatedUser.getUsername())) {
                user.setPassword(updatedUser.getPassword());
                break;
            }
        }
    }

    public User findUser(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
