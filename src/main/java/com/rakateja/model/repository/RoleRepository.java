package com.rakateja.model.repository;


import com.rakateja.model.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rakateja on 8/23/15.
 * @author Raka Teja
 */

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    public Role findByTitle(String title);

}
