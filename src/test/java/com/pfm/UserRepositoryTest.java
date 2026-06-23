package com.pfm;

import com.pfm.entity.User;
import com.pfm.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindByEmail() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("hashed_password");
        user.setFullName("Test User");

        userRepository.save(user);
        Optional<User> found = userRepository.findByEmail("test@example.com");

        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals("Test User", found.get().getFullName());
    }
}
