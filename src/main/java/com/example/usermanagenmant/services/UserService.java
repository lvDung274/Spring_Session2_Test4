package com.example.usermanagenmant.services;

import com.example.usermanagenmant.models.User;
import com.example.usermanagenmant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUser();
    }


    public List<User> findUsersWithSearch(String search) {
        List<User> users = findAllUsers();

        if (search != null && !search.trim().isEmpty()) {
            String keyword = search.toLowerCase().trim();
            return users.stream()
                    .filter(user -> user.getUsername() != null &&
                            user.getUsername().toLowerCase().contains(keyword))
                    .collect(Collectors.toList());
        }

        return users;
    }
    public User findUserById(Long id) {
        return userRepository.findById(id);
    }
}
