package com.evil.inc.evale.repository;

import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
