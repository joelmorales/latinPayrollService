package com.swacorp.mx.dataproviders.database.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swacorp.mx.dataproviders.database.domain.Customer;

@Repository
public interface CustomerTableDAO extends CrudRepository<Customer, String> {

}
