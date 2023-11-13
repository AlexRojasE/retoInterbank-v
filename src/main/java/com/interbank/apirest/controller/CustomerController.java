package com.interbank.apirest.controller;

import com.interbank.apirest.configuration.CryptoConfiguration;
import com.interbank.apirest.entity.Customer;
import com.interbank.apirest.service.CustomerService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers(){
    return customerService.findCustomers().stream().map(customer ->
    {
      customer.setIdentifyCustomer(CryptoConfiguration.encrypt(customer.getIdentifyCustomer()));
      return customer;
    }).collect(Collectors.toList());
  }

  @GetMapping("/search/{indentityCustomer}")
  public ResponseEntity<Customer> findByIdCustomer(@PathVariable String indentityCustomer){
    return ResponseEntity.ok(customerService.findByIdentifyCustomer(indentityCustomer));
  }

  @PostMapping("/save/customer")
  public ResponseEntity<Customer> updateCustomers (@RequestBody Customer customer) {
     //Customer customerFind = customerService.findByIdentifyCustomer(customer.getIdentifyCustomer());
    Customer customerFind = customerService.findByIdentifyCustomer(CryptoConfiguration.decrypt(customer.getIdentifyCustomer()));

     if(Objects.nonNull(customerFind)){
       Customer customerUpdate = new Customer();
       customerUpdate.setIdCustomer(customer.getIdCustomer());
       customerUpdate.setIdentifyCustomer(CryptoConfiguration.decrypt(customer.getIdentifyCustomer()));
       customerUpdate.setFirstName(customer.getFirstName());
       customerUpdate.setLastName(customer.getLastName());
       customerUpdate.setTypeDocument(customer.getTypeDocument());
       customerUpdate.setNumberDocument(customer.getNumberDocument());
       customerService.updateCustomer(customerUpdate);
       return ResponseEntity.ok(customerUpdate);
     }
     return null;
    }



}
