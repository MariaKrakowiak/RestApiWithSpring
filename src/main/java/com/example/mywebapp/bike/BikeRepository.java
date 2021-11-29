package com.example.mywebapp.bike;

import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike, Integer> {
    public Long countById(Integer id);


}
