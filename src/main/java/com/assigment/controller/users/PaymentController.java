package com.assigment.controller.users;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assigment.entity.Cart;
import com.assigment.entity.Oder;
import com.assigment.entity.OderDetails;
import com.assigment.entity.Product;
import com.assigment.service.impl.OderDetailsService;
import com.assigment.service.impl.OderService;
import com.assigment.service.impl.ProductService;


@Controller
@RequestMapping(value = "/pay")
public class PaymentController {
	
	@Autowired
	private OderService oderServices;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OderDetailsService oderDetailsService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping(value = "/home")
	public String home
	(
			Model model
	) {
		model.addAttribute("view", "/views/users/payment/payment_confirm.jsp");
		return "users/home";
	}
	
	@GetMapping(value = "/confirm")
	public String confirm
	(
			Model model,
			HttpSession session
	) {
		session = this.request.getSession();
		Oder oder = this.oderServices.getById(1);
		Product product = null;
		int sl = 0;
		int sld = 0;
		Collection<Cart> lstCart = (Collection<Cart>) session.getAttribute("lstcart");
		for (Cart cart : lstCart) {
			Integer id = cart.getProduct().getId();
			product = this.productService.getById(id);
			if(product.getId() == id) {
				sld = product.getQuantity() - cart.getQuantity();
				sl = cart.getQuantity();
				product.setQuantity(sld);
				OderDetails oderDetails = new OderDetails();
				oderDetails.setOder(oder);
				oderDetails.setProduct(product);
				oderDetails.setPrice(product.getPrice());
				oderDetails.setQuantity(sl);
				oderDetails.setTongTien(product.getPrice() * sl);
				this.oderDetailsService.insert(oderDetails);
			}
		}
		lstCart.clear();
		session.removeAttribute("lstcart");
		session.removeAttribute("toltal");
		return "redirect:/home";
	}
	
}
