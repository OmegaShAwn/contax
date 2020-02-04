package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index(String email) {
        String username = Security.connected();
        List<User> users = User.find("byUsername", username).fetch();
        User user = users.get(0);
        if (email != null) {
            List<User> friends = user.getFriends();
            List<User> usersWithEmail = User.find("byUsername", email).fetch();
            if (usersWithEmail.size() != 0) {
                User friend = usersWithEmail.get(0);
                if (!friends.contains(friend)) {
                    friends.add(friend);
                    user.setFriends(friends);
                    user = user.save();
                }
            }
        }
        render(user);
    }

    public static void settings(Date dob, Integer hours) {
        String username = Security.connected();
        User user;
        if (dob != null || hours != null) {
            List<User> users = User.find("byUsername", username).fetch();
            user = users.get(0);
            if (dob != null) user.setDateOfBirth(dob);
            if (hours != null) user.setNotifyBefore(hours);
            user = user.save();
        } else {
            List<User> users = User.find("byUsername", Security.connected()).fetch();
            user = users.get(0);
        }
        render(user);
    }

}