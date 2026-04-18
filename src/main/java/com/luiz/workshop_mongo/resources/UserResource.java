package com.luiz.workshop_mongo.resources;

import com.luiz.workshop_mongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User user1 = new User("1", "Luiz", "luiz@gmail.com");
        User user2 = new User("2", "Lara", "lara@gmail.com");
        List<User> list = Arrays.asList(user1, user2);
        return ResponseEntity.ok().body(list);
    }

}
