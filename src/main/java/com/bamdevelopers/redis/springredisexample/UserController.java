package com.bamdevelopers.redis.springredisexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){
        userRepository.save(new User(id,name,2000d));
        return userRepository.get(id);
    }
    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){
        userRepository.update(new User(id,name,1000d));
        return userRepository.get(id);
    }
    @GetMapping("/get/all")
    public Map<String,User> findAll(){
        return userRepository.getAllUser();
    }
}

