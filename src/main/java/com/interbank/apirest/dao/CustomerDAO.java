package com.interbank.apirest.dao;

import com.interbank.apirest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository <Customer,Long>{

  Customer findByIdentifyCustomer( String identifyCustomer );

}

