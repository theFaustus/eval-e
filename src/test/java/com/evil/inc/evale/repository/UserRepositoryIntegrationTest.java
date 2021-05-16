package com.evil.inc.evale.repository;

import com.evil.inc.evale.domain.User;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findByEmail() {
        final User user = new User();
        user.setFirstName("bobo");
        user.setEmail("bobo@gmail.com");

        userRepository.saveAll(List.of(user));

        Assertions.assertThat(userRepository.findByEmail("bobo@gmail.com")).isPresent();
        Assertions.assertThat(userRepository.findByEmail("bobo@gmail.com").get().getFirstName()).isEqualTo(user.getFirstName());
    }
}