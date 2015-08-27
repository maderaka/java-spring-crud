package com.rakateja.model.repository;

import com.rakateja.model.entity.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rakateja on 8/24/15.
 *
 * PhoneRepository interface
 * @author Raka Teja
 */

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {

    public List<Phone> findByUserId(Long userId);

}
