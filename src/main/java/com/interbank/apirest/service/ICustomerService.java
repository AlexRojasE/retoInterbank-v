package com.interbank.apirest.service;

import com.interbank.apirest.entity.Customer;
import java.util.List;

public interface ICustomerService {

  List<Customer> findCustomers();

  Customer updateCustomer(Customer customer);

  Customer findCustomer(Long uniqueCode);

  Customer findByIdentifyCustomer(String identifyCustomer);



}
