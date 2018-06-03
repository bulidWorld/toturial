package org.zwx.base.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zwx.base.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByName(String name);
}
