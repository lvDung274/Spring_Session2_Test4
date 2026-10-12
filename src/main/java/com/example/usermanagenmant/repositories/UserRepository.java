package com.example.usermanagenmant.repositories;

import com.example.usermanagenmant.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
    public class UserRepository {
    List<User> users = new ArrayList<>(
        Arrays.asList(
                new User(1L, "Le Van Dung", "dunglv@gmail.com" , "Admin" ),
                new User(1L, "Le Thanh Huong", "huong@gmail.com" , "Admin" ),
                new User(1L, "Le anh thu", "thu@gmail.com" , "Admin" )
            )
        );
    public List<User> findAllUser() {
        return users;
    }

}
