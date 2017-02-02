package org.victoryw.repositories;

import org.springframework.data.repository.CrudRepository;
import org.victoryw.domainModel.Customer;

/**
 * Created by victoryw on 2/2/17.
 */
public interface CustomerRepository
        extends CrudRepository<Customer, Long> {
}
