package com.assigment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assigment.entity.Product;
import com.assigment.repository.IProductRepository;
import com.assigment.service.impl.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private IProductRepository productRepo;
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
		Pageable pageable = PageRequest.of(page, 8);
		Page<Product> lstProduct = this.productRepo.findAll(pageable);
		model.addAttribute("lstproduct", lstProduct);
		model.addAttribute("view", "/views/users/home_sp/load_sp.jsp");
		return "users/home";
	}
	
	@RequestMapping("homeStaff")
	public String homeStaff() {
		return "admin/homeStaff";
	}
	
}
