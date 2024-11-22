package com.ex01_241122.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex01_241122.entity.Product;
import com.ex01_241122.entity.ProductDetail;
import com.ex01_241122.repository.ProductDetailRepository;
import com.ex01_241122.repository.ProductRepository;

@Controller
public class MainController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductDetailRepository productDetailRepository;
	
	@RequestMapping("/")
	public String root() {
		return "main";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Product> list = productRepository.findAll();
		List<ProductDetail> pdlist = productDetailRepository.findAll();
		//System.out.println("list" + list);
		model.addAttribute("list", list);
		model.addAttribute("pdlist", pdlist);
		return "list";
	}
	
	@GetMapping("/regForm")
	public String regForm(Model model) {
		Product p = new Product();
		model.addAttribute("product", p);
		return "regForm";
	}
	
	@PostMapping("/regist")
	public String regist(Product p) {
		productRepository.save(p);
		return "redirect:/list";
	}
	
	@GetMapping("/detailForm/{id}")
	public String detailForm(@PathVariable("id") int pno,
			Model model) {
		Optional<Product> result = productRepository.findById(pno);
		List<ProductDetail> list = productDetailRepository.findAll();
//		int tmp = list.get(list.size() - 1).getProduct().getPno();
//		System.out.println("tmp : " + tmp);
		System.out.println("pno : " + pno);
//		if(pno <= tmp) {
//			Optional<ProductDetail> result1 = productDetailRepository.findById(pno);		
//			Product p = result.get();
//			ProductDetail pd = result1.get();
//			System.out.println(pd);
//			model.addAttribute("product", p);
//			model.addAttribute("productDetail", pd);		
//			return "detailForm";
//		} else {		
			Product p = result.get();
			model.addAttribute("product", p);
			model.addAttribute("productDetail", new ProductDetail());			
			return "detailForm";
//		}
	}
	
	@PostMapping("/registDetail")
	public String registDetail(ProductDetail pd) {
		productDetailRepository.save(pd);
		return "redirect:/list";
	}
	
}
