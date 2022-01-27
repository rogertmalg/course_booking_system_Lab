package com.codeclan.example.coursebookingsystem.controllers;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/course")
    public ResponseEntity<List<Customer>> getCustomersByCourse(@RequestParam(name= "name") String name){
        return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(name), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/townandcourse")
    public ResponseEntity<List<Customer>> getCustomerByTownAndCourse(@RequestParam(name = "town") String town, @RequestParam(name = "course") String course){
        return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, course), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/olderthanandtownandcourse")
    public ResponseEntity<List<Customer>> getCustomersOlderThanAndByTownAndCourse(@RequestParam(name = "age") int age, @RequestParam(name = "town") String town, @RequestParam(name = "course") String course){
        return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, course), HttpStatus.OK);
    }


}
