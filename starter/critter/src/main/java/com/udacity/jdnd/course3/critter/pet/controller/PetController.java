package com.udacity.jdnd.course3.critter.pet.controller;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.dto.PetDTO;
import com.udacity.jdnd.course3.critter.pet.mapper.PetMapper;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private PetService petService;

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Long ownerId = petDTO.getOwnerId();
        Customer customer = null;
        if (ownerId != null) {
            customer = customerService.getCustomer(ownerId);
        }
        Pet pet = petMapper.DTOtoEntity(petDTO);
        pet.setCustomer(customer);
        Pet savedPet = petService.createPet(pet);
        return petMapper.entityToDTO(savedPet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Pet pet = petService.getPet(petId);
        if (pet != null) {
            return petMapper.entityToDTO(pet);
        }
        return null;
    }

    @GetMapping
    public List<PetDTO> getPets() {
        List<Pet> pets = petService.getAllPets();
        return petMapper.entitiesToDTOs(pets);
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        Customer customer = customerService.getCustomer(ownerId);
        List<Pet> pets = petService.getPetsByOwner(customer);
        return petMapper.entitiesToDTOs(pets);
    }
}
