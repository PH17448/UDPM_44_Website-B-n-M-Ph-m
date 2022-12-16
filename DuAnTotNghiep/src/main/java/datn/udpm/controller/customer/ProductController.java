package datn.udpm.controller.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import datn.udpm.entity.Product;
import datn.udpm.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService ;
	
	@RequestMapping("/product/list")
	public String list(Model model , @RequestParam("p") Optional<Integer> p ) {
			Pageable pageable = PageRequest.of(p.orElse(0), 4);
			Page<Product> page = productService.findAll(pageable);
			model.addAttribute("listProduct",page);
		return "customer/product/list";
	}
	
	
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id")Integer id) {
		Product product = productService.findById(id);
		model.addAttribute("item",product);
		return "customer/product/detail";
	}
	
	@GetMapping("/product/updateQuantity/{id}")
	public String updateQuantity(@PathVariable("id") Integer id) {
		Product product = productService.findById(id);
		product.setQuantity(product.getQuantity() - 1);
		productService.save(product);
		
		return "redirect:/cart/view";
	};
	
}
