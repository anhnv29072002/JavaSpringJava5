package com.assigment.controller.admin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.assigment.entity.Category;
import com.assigment.entity.Product;
import com.assigment.mapper.ProductMapper;
import com.assigment.model.ProductDTO;
import com.assigment.repository.IProductRepository;
import com.assigment.service.impl.CategoryService;
import com.assigment.service.impl.ProductService;
import com.assigment.utils.UploadFileUtils;

@Controller
@RequestMapping(value = "/dog")
public class QLDogController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private IProductRepository productRepo;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UploadFileUtils uploadUtils;
	
	@GetMapping(value = "/index")
	public String index
	(
			Model model,
			@RequestParam(name = "page",defaultValue = "0") Integer page
	) {
		Pageable pageable = PageRequest.of(page, 5);
		Page<Product> lstProduct = this.productRepo.findAll(pageable);
		List<Product> lst = this.productService.getAll();
		model.addAttribute("lst", lst);
		model.addAttribute("lstproduct", lstProduct);
		model.addAttribute("view", "/views/admin/qlproduct/index.jsp");
		return "admin/homeStaff";
	}
	
	@GetMapping(value = "/create")
	public String create
	(
			Model model,
			@ModelAttribute("product") ProductDTO productDTO
	) {
		List<Category> lstCategory = this.categoryService.getAll();
		model.addAttribute("lstcategory", lstCategory);
		model.addAttribute("view", "/views/admin/qlproduct/create.jsp");
		return "admin/homeStaff";
	}
	
	@PostMapping(value = "/store")
	public String store
	(
			Model model,
			@Valid @ModelAttribute("product") ProductDTO productDTO,
			BindingResult result,
			@RequestParam("createdDate") String date,
			@RequestParam("image_file") MultipartFile file,
			HttpSession session
	) {
		session = this.request.getSession();
		if(result.hasErrors() == true) {
			session.setAttribute("error", "Thêm thất bại");
			List<Category> lstCategory = this.categoryService.getAll();
			model.addAttribute("lstcategory", lstCategory);
			model.addAttribute("view", "/views/admin/qlproduct/create.jsp");
			return "admin/homeStaff";
		}else {
			File img = this.uploadUtils.handleUploadFile(file);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date ngayTao = null;
			try {
				ngayTao = sdf.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Product product = this.productMapper.convertToEntity(productDTO);
			product.setImage(img.getName());
			product.setCreatedDate(ngayTao);
			this.productService.insert(product);
			session.setAttribute("message", "Thêm thành công");
			return "redirect:/dog/index";
		}
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(Model model,@PathVariable("id") Product product) {
		List<Category> lstCategory = this.categoryService.getAll();
		ProductDTO productDTO = this.productMapper.convertToDTO(product);
		model.addAttribute("product", productDTO);
		model.addAttribute("lstcategory", lstCategory);
		model.addAttribute("view", "/views/admin/qlproduct/edit.jsp");
		return "admin/homeStaff";
	}
	
	@PostMapping(value = "/update/{id}")
	public String update
	(
			Model model,
			@PathVariable("id") Integer id,
			@Valid @ModelAttribute("product") ProductDTO productDTO,
			BindingResult result,
			@RequestParam("createdDate") String date,
			@RequestParam("image_file") MultipartFile file,
			HttpSession session
	) {
			File img = this.uploadUtils.handleUploadFile(file);
			Product product1 = this.productService.getById(id);
			Product product = this.productMapper.convertToEntity(productDTO);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date ngayTao = null;
			try {
				ngayTao = sdf.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			product.setCreatedDate(ngayTao);
			
			product.setImage(img.getName());
			if(img.getName().equals("")) {
				product.setImage(product1.getImage());
			}else if(img.getName().equals("img")) {
				product.setImage(product1.getImage());
			}
			this.productService.update(product);
			session.setAttribute("message", "Sửa thành công");
			return "redirect:/dog/index";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete
	(
			@PathVariable("id") Integer id,
			HttpSession session
	) {
		session = this.request.getSession();
		if(id != null) {
			this.productService.deleteById(id);
			session.setAttribute("message", "Xóa thành công");
			return "redirect:/dog/index";
		}else {
			session.setAttribute("error", "Xóa thất bại");
			return "redirect:/dog/index";
		}
	}
	
	@GetMapping(value = "/search", params = "name")
	public String search
	(
			Model model,
			@RequestParam("name") String name,
			@RequestParam(name = "page",defaultValue = "0") Integer page
	) {
		Pageable pageable = PageRequest.of(page, 5);
		Page<Product> lstProduct = this.productService.searchName(name, pageable);
		List<Product> lst = this.productService.getAll();
		model.addAttribute("lst", lst);
		model.addAttribute("lstproduct", lstProduct);
		model.addAttribute("view", "/views/admin/qlproduct/index.jsp");
		return "admin/homeStaff";
	}
	
}
