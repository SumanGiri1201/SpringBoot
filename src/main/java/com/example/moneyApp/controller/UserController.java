package com.example.moneyApp.controller;

import com.example.moneyApp.model.User;
import com.example.moneyApp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;

        // Create User A and User B if not already present
        if (repo.count() == 0) {
            repo.save(new User(1, "User A", 10000));
            repo.save(new User(2, "User B", 0));
        }
    }

    @GetMapping("/send/{amount}")
    public String sendMoneyByUrl(@PathVariable double amount) {
        User a = repo.findById(1).orElse(null); // User A
        User b = repo.findById(2).orElse(null); // User B

        if (a == null || b == null) return "User not found.";
        if (amount <= 0) return "Invalid amount.";
        if (a.balance < amount) return "Insufficient balance.";

        a.balance -= amount;
        b.balance += amount;

        repo.save(a);
        repo.save(b);

        return "₹" + amount + " sent from User A to User  B";
    }
    @GetMapping("/receive")
    public String checkUserBReceived() {
        User b = repo.findById(2).orElse(null); // User B

        if (b == null) return "User B not found.";

        return "User B has ₹" + b.balance;
    }
}
