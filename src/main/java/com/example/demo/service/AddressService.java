package com.example.demo.service;

import com.example.demo.Address;
import com.example.demo.Users;
import com.example.demo.repoitory.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findById(Long userId){
        return addressRepository.findById(userId).orElse(null);
    }


//далее уже допишите сами)
}
