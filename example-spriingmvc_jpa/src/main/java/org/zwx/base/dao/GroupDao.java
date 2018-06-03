package org.zwx.base.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zwx.base.entity.Group;

@Repository
public interface GroupDao extends CrudRepository<Group, Integer> {
}
