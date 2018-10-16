package com.swacorp.mx.dataproviders.database.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swacorp.mx.dataproviders.database.domain.EmployeePayment;

@Repository
public interface EmployeePaymentTableDAO extends CrudRepository<EmployeePayment,String>{
	@Query("select e from EmployeePayment e where e.id = :id ")
	List<EmployeePayment> findById(@Param("id") String id);
}
