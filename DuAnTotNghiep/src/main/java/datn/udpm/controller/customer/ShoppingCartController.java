package datn.udpm.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import datn.udpm.entity.Order;
import datn.udpm.entity.OrderDetail;
import datn.udpm.entity.Product;
import datn.udpm.service.OrderDetailService;
import datn.udpm.service.OrderService;
import datn.udpm.service.ProductService;

@Controller
public class ShoppingCartController {
	
	@Autowired
	ProductService productService ;
	
	@Autowired 
	OrderService orderService ;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@RequestMapping("cart/view")
	public String view() {
		
		
		
		return "customer/cart/view";
	}
	
	@GetMapping("/resetQuantity")
	public String resetQuantity(@RequestParam Integer id ,@RequestParam Integer qty) {
		
		Product product = productService.findById(id);
		
		product.setQuantity(product.getQuantity() + qty);
		
		productService.save(product);
		
		return "customer/cart/view";
	}
}
