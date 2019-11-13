package com.bamdevelopers.redis.springredisexample;

import java.util.Map;

public interface UserRepository {
    void save(User user);

    User get(String id);

    Map<String, User> getAllUser();

    void update(User user);

    void delete(String id);
}
