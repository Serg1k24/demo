package com.example.demo;

import com.example.demo.service.UserService;
import com.example.demo.service.AddressService;
import com.example.demo.Address;
import com.example.demo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringjpapostgresApplication {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(SpringjpapostgresApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods(){
        Address address = new Address();
        address.setCity("Kiev");
        address.setHomeNumber("4");
        address.setStreet("Main Street");

        Address address1 = new Address();
        address1.setCity("Lviv");

        Address addressk = new Address();
        addressk.setCity("Murmansk");
        addressk.setHomeNumber("5");
        addressk.setStreet("Kovalsky");
        addressService.createAddress(addressk);
        addressService.createAddress(address);
        addressService.createAddress(address1);


        Users userska = new Users();
        userska.setAddress(addressk);
        userska.setEmail("hat@mail.ru");
        userska.setName("Gosha");
        userService.createUsers(userska);

        Users users = new Users();
        users.setAddress(address);
        users.setEmail("someEmail@gmail.com");
        users.setName("Smith");
        userService.createUsers(users);

        Users users1 = new Users();
        users1.setName("Jon Dorian");
        users1.setEmail("gmailEmail@gmail.com");
        users1.setAddress(address1);


        userService.createUsers(users1);

        userService.findAll().forEach(it-> System.out.println(it));

        userService.findAllByName("Smith").forEach(it-> System.out.println(it));

        userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));

        userService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));
    }
}