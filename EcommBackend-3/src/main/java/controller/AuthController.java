package controller;

import entity.User;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService = new UserService();

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully";
    }

    @GetMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
}

