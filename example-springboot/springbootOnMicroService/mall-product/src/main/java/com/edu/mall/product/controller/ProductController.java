package com.edu.mall.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.mall.product.bean.Product;
import com.edu.mall.product.mapper.ProductMapper;
import com.edu.mall.product.web.Response;

/**
 *  product rest 服务
 */
@RestController
public class ProductController {

	@Autowired
	private ProductMapper productMapper;
	
	@PostMapping("/soa/product/add")
	public Object add(Product product) {
		Integer res = productMapper.add(product);
		return res == 1 ? new Response("200", "OK") : new Response("500", "Fail");
	}
	
	@PutMapping("/soa/product/update")
	public Object update(Product product) {
		Integer res = productMapper.update(product);
		return res == 1 ? new Response("200", "OK") : new Response("500", "Fail");
	}
	
	@DeleteMapping("/soa/product/{id}")
	public Object delete(@PathVariable("id") Integer id) {
		Integer res = productMapper.deleteById(id);
		return res == 1 ? new Response("200", "OK") : new Response("500", "Fail");
	}
	
	@GetMapping("/soa/product/{id}")
	public Object get(@PathVariable("id") Integer id) {
		Product product = productMapper.getById(id);
		return new Response("200", "OK", product);
	}
	
	@GetMapping("/soa/products")
	public Object list() {
		return new Response("200", "OK", productMapper.queryByLists());
	}
}















