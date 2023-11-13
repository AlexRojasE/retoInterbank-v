package com.interbank.apirest.service;

import com.interbank.apirest.dao.CustomerDAO;
import com.interbank.apirest.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

  @Autowired
  private CustomerDAO customerDAO;


  @Override
  public List<Customer> findCustomers() {
    return customerDAO.findAll();
  }

  @Override
  public Customer updateCustomer(Customer customer) {
    return customerDAO.save(customer);
  }

  @Override
  public Customer findCustomer(Long uniqueCode) {
    return customerDAO.findById(uniqueCode).orElse(new Customer());
  }

  @Override
  public Customer findByIdentifyCustomer(String identifyCustomer) {
    return customerDAO.findByIdentifyCustomer(identifyCustomer);
  }


}
