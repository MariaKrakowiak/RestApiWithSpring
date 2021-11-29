package com.example.mywebapp.bike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository repo;

    public List<Bike> listAll(){
        return (List<Bike>) repo.findAll();
    }

    public void save(Bike bike) {
        repo.save(bike);
    }

    public Bike get(Integer id) throws BikeNotFoundException {
        Optional<Bike> byId = repo.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        throw new BikeNotFoundException("Could not find any bike with following id.");
    }

    public void delete(Integer id) throws BikeNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count ==0){
            throw new BikeNotFoundException("Could not find any bike with following id.");
        }
        repo.deleteById(id);
    }
}
