package com.udacity.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.exceptions.BreedNotFoundException;
import com.udacity.bootstrap.exceptions.DogNotFoundException;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Iterable<String> findDogBreeds() {
        Iterable<Dog> allDogs = dogRepository.findAll();
        ArrayList<String> allBreeds = new ArrayList<>();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
            allBreeds.add(d.getBreed());
        }
        return allBreeds;
    }

    public Iterable<String> findDogNames() {
        Iterable<Dog> allDogs = dogRepository.findAll();
        ArrayList<String> allDogNames = new ArrayList<>();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
            allDogNames.add(d.getName());
        }
        return allDogNames;
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

    public String findBreedById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get().getBreed();
        } else {
            throw new BreedNotFoundException("BreedNotFound", id.toString());
        }
    }
}
