package com.rakateja.model.repository;

import com.rakateja.model.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rakateja on 8/24/15.
 *
 * CountryRepository interface
 * @author Raka Teja
 */

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
