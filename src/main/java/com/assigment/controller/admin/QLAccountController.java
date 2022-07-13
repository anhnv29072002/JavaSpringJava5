package com.assigment.controller.admin;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.assigment.entity.Account;
import com.assigment.mapper.AccountMapper;
import com.assigment.model.AccountDTO;
import com.assigment.service.impl.AccountService;
import com.assigment.utils.EncryptUtils;
import com.assigment.utils.UploadFileUtils;

@Controller
@RequestMapping(value = "/account")
public class QLAccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private UploadFileUtils uploadUtils;
	
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		List<Account> lstAccount = this.accountService.getAll();
		model.addAttribute("lstaccount", lstAccount);
		model.addAttribute("view", "/views/admin/qlaccount/index.jsp");
		return "admin/homeStaff";
	}
	
	@GetMapping(value = "/create")
	public String create(@ModelAttribute("account") AccountDTO accountDTO,Model model) {
		model.addAttribute("view", "/views/admin/qlaccount/create.jsp");
		return "admin/homeStaff";
	}
	
	@PostMapping(value = "/store")
	public String store
	(
			Model model,
			@Valid @ModelAttribute("account") AccountDTO accountDTO,
			BindingResult result,
			@RequestParam("photo_file") MultipartFile file,
			HttpSession session
	) {
		session = this.request.getSession();
		if(result.hasErrors() == true) {
			session.setAttribute("error", "Thêm thất bại");
			model.addAttribute("view", "/views/admin/qlaccount/create.jsp");
			return "admin/homeStaff";
		}else {
			File img = this.uploadUtils.handleUploadFile(file);
			Account account = this.accountMapper.convertToEntity(accountDTO);
			String encrypted = EncryptUtils.encrypt(this.request.getParameter("password"));
			account.setPassword(encrypted);
			account.setPhoto(img.getName());
			this.accountService.insert(account);
			session.setAttribute("message", "Thêm thành công");
			return "redirect:/account/index";
		}
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit
	(
			Model model,
			@PathVariable("id") Account account
	) {
		AccountDTO accountDTO = this.accountMapper.convertToDTO(account);
		model.addAttribute("account", accountDTO);
		model.addAttribute("view", "/views/admin/qlaccount/edit.jsp");
		return "admin/homeStaff";
	}
	
	@PostMapping(value = "/update/{id}")
	public String update
	(
		Model model,
		@PathVariable("id") Integer id,
		@Valid @ModelAttribute("account") AccountDTO accountDTO,
		BindingResult result,
		@RequestParam("photo_file") MultipartFile file,
		HttpSession session
	) {
			session = this.request.getSession();
			File img = this.uploadUtils.handleUploadFile(file);
			Account account1 = this.accountService.getById(id);
			Account account = this.accountMapper.convertToEntity(accountDTO);
			account.setPhoto(img.getName());
			account.setPassword(account1.getPassword());
			if(img.getName().equals("")) {
				account.setPhoto(account1.getPhoto());
			}else if(img.getName().equals("img")) {
				account.setPhoto(account1.getPhoto());
			}
			this.accountService.update(account);
			session.setAttribute("message", "Sửa thành công");
			return "redirect:/account/index";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete
	(
			@PathVariable("id") Integer id,
			HttpSession session
	) {
		session = this.request.getSession();
		if(id == null) {
			session.setAttribute("error", "Xóa thất bại");
			return "redirect:/account/index";
		}else {
			this.accountService.deleteById(id);
			session.setAttribute("message", "Xóa thành công");
			return "redirect:/account/index";
		}
	}
	
}
