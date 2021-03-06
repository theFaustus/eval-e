package com.evil.inc.evale.service;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.User;

import java.util.List;

public interface UserService {
    void create(User user);
    public List<User> getAll();
}
