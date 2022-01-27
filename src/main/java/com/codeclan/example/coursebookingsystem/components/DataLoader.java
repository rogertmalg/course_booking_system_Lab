package com.codeclan.example.coursebookingsystem.components;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Customer customer1 = new Customer("Andrew", "Edinburgh", 26);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Roger", "Edinburgh", 26);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Brian", "Glasgow", 26);
        customerRepository.save(customer3);
        Customer customer4 = new Customer("Lucy", "Aberdeen", 26);
        customerRepository.save(customer4);


        Course course1 = new Course("Intro to Python", "Edinburgh", 3);
        courseRepository.save(course1);
        Course course2 = new Course("Intro to Java", "Edinburgh", 4);
        courseRepository.save(course2);
        Course course3 = new Course("Advanced React", "Aberdeen", 3);
        courseRepository.save(course3);
        Course course4 = new Course("Programming basics", "Glasgow", 2);
        courseRepository.save(course4);

        Booking booking1 = new Booking("11-02-2022", customer1, course1);
        Booking booking2 = new Booking("20-02-2022", customer2, course2);
        Booking booking3 = new Booking("14-02-2022", customer3, course3);
        Booking booking4 = new Booking("23-02-2022", customer4, course4);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);

        course1.addBooking(booking1);
        course2.addBooking(booking2);
        course3.addBooking(booking3);
        course4.addBooking(booking4);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);



        customer1.addBooking(booking1);
        customer2.addBooking(booking2);
        customer3.addBooking(booking3);
        customer4.addBooking(booking4);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
    }

}