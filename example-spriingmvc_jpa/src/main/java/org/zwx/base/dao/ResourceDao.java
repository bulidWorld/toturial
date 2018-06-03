package org.zwx.base.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zwx.base.entity.Resource;

@Repository
public interface ResourceDao extends CrudRepository<Resource, Integer> {
}
