package service;

import entity.User;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void registerUser(User user) {
        // Add any additional business logic here
        userRepository.save(user);
    }
}

