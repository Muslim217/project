package my.app.project.controller;

import my.app.project.model.Customer;
import my.app.project.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl service;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        service.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(service.getCustomer(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
