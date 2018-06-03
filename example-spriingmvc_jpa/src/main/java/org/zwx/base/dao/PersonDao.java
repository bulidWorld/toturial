package org.zwx.base.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zwx.base.entity.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Long> {
}
