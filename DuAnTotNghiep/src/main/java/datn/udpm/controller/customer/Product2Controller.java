package datn.udpm.controller.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import datn.udpm.entity.Product;
import datn.udpm.service.ProductService;

@Controller
public class Product2Controller {

	@Autowired
	ProductService productService	;
	
	@GetMapping("/product/list/category")
	public String list(Model model,@RequestParam("cid") Optional<Integer> cid) {
		
		if (cid.isPresent()) {
			List<Product> list = productService.findBySubCategoryId(cid.get());
			model.addAttribute("listProductCate",list);
		}
		return "customer/product/list2";
	}
}
