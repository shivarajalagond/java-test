package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;

public class UserDao {

    public ArrayList<User> users = new ArrayList<>();

    public static UserDao userDao;

    public static UserDao getUserDao() {
        return userDao;
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
            return users;
    }

    public void deleteUser(User userToDelete) {
        try {
            for (User user : users) {
                if (user.getName() == userToDelete.getName()) {
                    users.remove(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User userToUpdate) {
        try {
            for (User user : users) {
                if (user.getName() == userToUpdate.getName()) {
                    user.setEmail(userToUpdate.getEmail());
                    user.setRoles(userToUpdate.getRoles());
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public User findUser(String name) {    
            for (User user : users) {
                if (user.getName() == name) {
                    return user;
                }
            }
        return null;
    }
}
