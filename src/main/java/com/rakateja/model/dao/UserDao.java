package com.rakateja.model.dao;

import com.rakateja.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by rakateja on 8/22/15.
 * @author Raka Teja
 */

@Repository
@Transactional
public class UserDao {

    public void create(User user) {
        entityManager.persist(user);
        return;
    }

    public List<User> findAll() {
        List<User> users = entityManager.createQuery("from User").getResultList();
        return users;
    }

    public User findByEmail(String email) {
        User user = (User) entityManager
                .createQuery("from User where email = :email")
                .setParameter("email", email)
                .getSingleResult();

        return user;
    }

    public User findById(long id) {
        User user = (User) entityManager.find(User.class, id);
        return user;
    }

    public void update(User user) {
        entityManager.merge(user);
        return;
    }

    public void delete(User user) {
        if(entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.remove(entityManager.merge(user));
        }
        return;
    }

    @PersistenceContext
    private EntityManager entityManager;
}
