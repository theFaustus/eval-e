package com.evil.inc.evale.service;

import com.evil.inc.evale.domain.User;
import com.evil.inc.evale.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }
}
