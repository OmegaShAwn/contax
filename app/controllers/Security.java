package controllers;

import models.User;

import java.util.List;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        List<User> users = User.find("byUsername", username).fetch();
        if (users.size() == 0) {
            // Add email verification.
            User user = new User(username, password);
            user.save();
            return true;
        }
        return (username.equals(users.get(0).getUsername()) && password.equals(users.get(0).getPassword()));
    }
}