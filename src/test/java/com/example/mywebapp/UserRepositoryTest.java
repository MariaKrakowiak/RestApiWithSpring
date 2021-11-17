package com.example.mywebapp;

import com.example.mywebapp.user.User;
import com.example.mywebapp.user.UserRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("user@user.com");
        user.setFirstName("User");
        user.setLastName("User");
        user.setPassword("user123");

        User savedUser = repo.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testFindAll() {
        Iterable<User> all = repo.findAll();

        Assertions.assertThat(all).hasSizeGreaterThan(0);

        for (User user : all) {
            System.out.println(user);
        }

    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> byId = repo.findById(userId);

        User user = byId.get();
        user.setPassword("sth");
        repo.save(user);

        User updatedUser = repo.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword().equals("sth"));

    }

    @Test
    public void testGet() {
        Integer userId = 1;
        Optional<User> byId = repo.findById(userId);

        Assertions.assertThat(byId).isPresent();
        System.out.println(byId.get());

    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        repo.deleteById(userId);
        Optional<User> byId = repo.findById(userId);
        Assertions.assertThat(byId).isNotPresent();
    }
}
