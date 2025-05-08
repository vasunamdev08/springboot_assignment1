package com.vena.assignment1.dataSeeder;

import com.vena.assignment1.dao.UserRepository;
import com.vena.assignment1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private final UserRepository userRepository;

    public DataSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User user1 = new User("John Doe", "johndoe@gmail.com", "password123");
            User user2 = new User("Jane Smith", "janesmith@gmail.com", "password456");
            User user3 = new User("Alice Johnson", "alicejhonson@gmail.com", "password789");

            userRepository.saveAll(List.of(user1, user2,user3));

            System.out.println("Seeded initial user data.");
        }
    }
}
