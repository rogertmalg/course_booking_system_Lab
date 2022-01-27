package com.codeclan.example.coursebookingsystem.controllers;

import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
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
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/rating")
    public ResponseEntity<List<Course>> getCourseByRating(@RequestParam (name = "rating") int rating){
        return new ResponseEntity<>(courseRepository.findByStarRating(rating), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/customer")
    public ResponseEntity<List<Course>> getCoursesByCustomer(@RequestParam(name= "name") String name){
        return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
    }
}
