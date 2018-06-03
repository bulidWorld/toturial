package com.edu.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addProduct(String name){
		String sql = "insert into product (pname)values('"+name+"')";
		jdbcTemplate.execute(sql);
	}
	
	/**
	 * rollbackFor 设置对哪些异常进行回滚，默认是运行时异常
	 * noRollbackFor 设置哪些异常不回滚
	 */
	@Transactional()
	public void addProductBatch(String ... names) throws Exception {
		add(names);
	}
	
	@Transactional()
	public void add(String ... names){
		for(String name : names){
			String sql = "insert into product (pname)values('"+name+"')";
			jdbcTemplate.execute(sql);
			if("".equals("")){
				throw new NullPointerException();
			}
		}
	}
}
