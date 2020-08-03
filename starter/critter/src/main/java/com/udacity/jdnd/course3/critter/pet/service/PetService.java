package com.udacity.jdnd.course3.critter.pet.service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet getPet(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    public List<Pet> getPetsByIds(List<Long> ids) {
        List<Pet> pets = new ArrayList<>();
        if (ids != null) {
            for (Long id : ids) {
                Optional<Pet> petOptional = petRepository.findById(id);
                petOptional.ifPresent(pets::add);
            }
        }
        return pets;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(Customer customer) {
        return petRepository.findAllByOwner(customer);
    }
}
