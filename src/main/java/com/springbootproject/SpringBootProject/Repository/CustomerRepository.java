package com.springbootproject.SpringBootProject.Repository;

import com.springbootproject.SpringBootProject.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository {
    extends JpaRepository<CustomerModel, Long> {

        @Query("SELECT c FROM CustomerModel WHERE c.username = ?1")
        Optional<CustomerModel> findCustomerByUsername(String username);
    }
}
