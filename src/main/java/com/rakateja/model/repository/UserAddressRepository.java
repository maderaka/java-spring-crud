package com.rakateja.model.repository;

import com.rakateja.model.entity.UserAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rakateja on 8/24/15.
 *
 * @author Raka Teja
 */

@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {

    public List<UserAddress> findByUser(Long userId);

}
