package org.zwx.dao;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.zwx.model.Person;

@MapperScan
public interface PersonMapper {
    Person findById(Integer id);

    @Select("select * from tbl_person")
    Person findSth(Integer id);
}
