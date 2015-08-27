package com.rakateja.model.repository;

import com.rakateja.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rakateja on 8/23/15.
 *
 * @author Raka Teja
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);

}
