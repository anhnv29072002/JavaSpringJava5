package com.assigment.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assigment.entity.Account;
import com.assigment.entity.Category;
import com.assigment.mapper.CategoryMapper;
import com.assigment.model.CategotyDTO;
import com.assigment.service.impl.AccountService;
import com.assigment.service.impl.CategoryService;

@Controller
@RequestMapping(value = "/category")
public class QLCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CategoryMapper cateMapper;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		List<Category> lstCategory = this.categoryService.getAll();
		model.addAttribute("lstcategory", lstCategory);
		model.addAttribute("view", "/views/admin/qlcategory/index.jsp");
		return "admin/homeStaff";
	}
	
	@GetMapping(value = "/create")
	public String create(Model model,@ModelAttribute("category") CategotyDTO categoryDTO) {
		List<Account> lstAccount = this.accountService.getAll();
		model.addAttribute("lstaccount", lstAccount);
		model.addAttribute("view", "/views/admin/qlcategory/create.jsp");
		return "admin/homeStaff";
	}
	
	@PostMapping(value = "/store")
	public String store
	(
		Model model,
		@Valid @ModelAttribute("category") CategotyDTO categoryDTO,
		BindingResult result,
		HttpSession session
	) {
		session = this.request.getSession();
		if(result.hasErrors() == true) {
			List<Account> lstAccount = this.accountService.getAll();
			model.addAttribute("lstaccount", lstAccount);
			session.setAttribute("error", "Thêm thất bại");
			model.addAttribute("view", "/views/admin/qlcategory/create.jsp");
			return "admin/homeStaff";
		}else {
			Category categoty = this.cateMapper.convertToEntity(categoryDTO);
			this.categoryService.insert(categoty);
			session.setAttribute("message", "Thêm thành công");
			return "redirect:/category/index";
		}
		
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit
	(
			Model model,
			@PathVariable("id") Category category
	) {
		CategotyDTO categoryDTO = this.cateMapper.convertToDTO(category);
		List<Account> lstAccount = this.accountService.getAll();
		model.addAttribute("category", categoryDTO);
		model.addAttribute("lstaccount", lstAccount);
		model.addAttribute("view", "/views/admin/qlcategory/edit.jsp");
		return "admin/homeStaff";
	}
	
	@PostMapping(value = "/update/{id}")
	public String update
	(
			Model model,
			@PathVariable("id") Integer id,
			@Valid @ModelAttribute("catogory") CategotyDTO categotyDTO,
			BindingResult result,
			HttpSession session
	) {
		session = this.request.getSession();
		if(result.hasErrors() == true) {
			session.setAttribute("error", "Sửa thất bại");
			return "redirect:/category/edit/"+id;
		}else {
			Category category = this.cateMapper.convertToEntity(categotyDTO);
			this.categoryService.update(category);
			session.setAttribute("message", "Sửa thành công");
			return "redirect:/category/index";
		}
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete
	(
			@PathVariable("id") Integer id,
			HttpSession sesison
	) {
		sesison = this.request.getSession();
		if(id == null) {
			sesison.setAttribute("error", "Xóa thất bại");
			return "redirect:/category/index";
		}else {
			this.categoryService.deleteById(id);
			sesison.setAttribute("message", "Xóa thành công");
			return "redirect:/category/index";
		}
	}
	
}
