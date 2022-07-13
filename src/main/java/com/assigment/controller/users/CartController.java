package com.assigment.controller.users;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assigment.entity.Cart;
import com.assigment.entity.Product;
import com.assigment.service.impl.CartService;
import com.assigment.service.impl.ProductService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	
	@Autowired
	private CartService cartServices;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private HttpServletRequest request;
	
	@GetMapping(value = "/home")
	public String home(Model model, HttpSession session) {
		session = this.request.getSession();
		Collection<Cart> lstCart = this.cartServices.getAll();
		session.setAttribute("lstcart", lstCart);
		session.setAttribute("toltal", this.cartServices.getTotal());
		model.addAttribute("view", "/views/users/cart_ui/cart.jsp");
		return "users/home";
	}
	
	@GetMapping(value = "/add/{productId}")
	public String add
	(
			@PathVariable("productId") Integer id
	) {
		Product product = this.productService.getById(id);
		if(product != null) {
			Cart cart = new Cart();
			cart.setProduct(product);
			cart.setQuantity(1);
			this.cartServices.addToCart(cart);
		}
		return "redirect:/home";
	}
	
	@PostMapping(value = "/updateUp/{productId}")
	public String updateUp
	(
			@PathVariable("productId") Integer id
	) {
		this.cartServices.updateToCartUp(id);
		return "redirect:/cart/home";
	}
	
	@PostMapping(value = "/updateDown/{productId}")
	public String updateDown
	(
			@PathVariable("productId") Integer id
	) {
		
		this.cartServices.updateToCartDown(id);
		return "redirect:/cart/home";
	}
	
	@GetMapping(value = "/delete/{productId}")
	public String delete
	(
			@PathVariable("productId") Integer id
	) {
		this.cartServices.delete(id);
		return "redirect:/cart/home";
	}
	
	@GetMapping(value = "/clear")
	public String clear(Model model,HttpSession session) {
		session = this.request.getSession();
		Collection<Cart> lstCart = this.cartServices.getAll();
		lstCart.clear();
		session.removeAttribute("lstcart");
		session.removeAttribute("toltal");
		session.setAttribute("lstcart", lstCart);
		model.addAttribute("view", "/views/users/cart_ui/cart.jsp");
		return "users/home";
	}
	
}
