package com.example.demo.db;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        //delete all
        this.userRepository.deleteAll();

        //Create users
        User nam = new User("nam", passwordEncoder.encode("nam123")
                ,"USER","");
        User admin = new User("admin", passwordEncoder.encode("admin123")
                ,"ADMIN","ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager123"),
                "MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(nam,admin,manager);

        //Save to db
        this.userRepository.saveAll(users);
    }
}
