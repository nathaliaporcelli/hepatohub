package service;

import models.User;

public interface UserService {
    User register(User user);
    boolean isEmailUnique(String email);
}

