/*package com.example.mywebapp;

import com.example.mywebapp.user.Bike;
import com.example.mywebapp.user.BikeRepository;
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
public class BikeRepositoryTest {
    @Autowired
    private BikeRepository repo;

    @Test
    public void testAddNew() {
        Bike bike = new Bike();
        bike.setEmail("user@user.com");
        bike.setFirstName("User");
        bike.setLastName("User");
        bike.setPassword("user123");

        Bike savedBike = repo.save(bike);
        Assertions.assertThat(savedBike).isNotNull();
        Assertions.assertThat(savedBike.getId()).isGreaterThan(0);

    }

    @Test
    public void testFindAll() {
        Iterable<Bike> all = repo.findAll();

        Assertions.assertThat(all).hasSizeGreaterThan(0);

        for (Bike bike : all) {
            System.out.println(bike);
        }

    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<Bike> byId = repo.findById(userId);

        Bike bike = byId.get();
        bike.setPassword("sth");
        repo.save(bike);

        Bike updatedBike = repo.findById(userId).get();
        Assertions.assertThat(updatedBike.getPassword().equals("sth"));

    }

    @Test
    public void testGet() {
        Integer userId = 1;
        Optional<Bike> byId = repo.findById(userId);

        Assertions.assertThat(byId).isPresent();
        System.out.println(byId.get());

    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        repo.deleteById(userId);
        Optional<Bike> byId = repo.findById(userId);
        Assertions.assertThat(byId).isNotPresent();
    }
}*/
