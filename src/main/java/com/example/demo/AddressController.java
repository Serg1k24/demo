package com.example.demo;

import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/address",method = RequestMethod.POST)
    public Address crad(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/address/{id}",method = RequestMethod.GET)
    public Address address(@PathVariable Long id) {
        return addressService.findById(id);
    }

    //@RequestMapping(value = "/address",method = RequestMethod.PUT)

    //@RequestMapping(value = "/address",method = RequestMethod.DELETE)
}
