package com.assigment.controller.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assigment.entity.OderDetails;
import com.assigment.repository.IOderDetalsRepository;
import com.assigment.service.impl.OderDetailsService;

@Controller
public class BillDetailsController {

	@Autowired
	private IOderDetalsRepository oderDetailsRepo;

	@RequestMapping(value = "/bill")
	public String bill(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
		Pageable pageable = PageRequest.of(page, 5);
		Page<OderDetails> lstOderDetails = this.oderDetailsRepo.findAll(pageable);
		model.addAttribute("lstoderdetails", lstOderDetails);
		model.addAttribute("view", "/views/users/bill_details/bill.jsp");
		return "users/home";
	}

}
