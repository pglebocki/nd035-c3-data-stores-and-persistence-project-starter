package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PetService petService;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        Customer customer = customerRepository.getOne(id);
        List<Pet> pets = petService.getPetsByOwner(customer);
        customer.setPets(pets);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer: customers) {
            List<Pet> pets = petService.getPetsByOwner(customer);
            customer.setPets(pets);
        }
        return customers;
    }
}
