package datn.udpm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import datn.udpm.entity.DiscountProduct;
import datn.udpm.service.DiscountService;

@Controller
public class DiscountAdminController {
	@Autowired
	DiscountService discountService;
	
	@GetMapping("admin/discount")
	public String get( Model model) {
		
		model.addAttribute("listDiscount",discountService.findAll());
		
		return "admin/discount/table";
	}
	
	
	@GetMapping("/admin/discount/create")
	public String create(Model model) {
		
		model.addAttribute("discount",new DiscountProduct());
		
		return "admin/discount/create";
	}
	
	@PostMapping("/admin/discount/save")
	public String save(@ModelAttribute("discount") DiscountProduct discountProduct) {
		
		discountService.save(discountProduct);
		
		return "redirect:/admin/discount";
	}
	
	@GetMapping("/admin/discount/edit/{id}")
	public String edit(@PathVariable("id") Integer id , Model model) {
		
		model.addAttribute("discount",discountService.findById(id));
		return "admin/discount/edit";
	}
	
	@PostMapping("/admin/discount/update/{id}")
	public String update(@PathVariable("id") Integer id ,@ModelAttribute("discount") DiscountProduct discountProduct) {
		
		DiscountProduct result = discountService.findById(id);
		result.setName(discountProduct.getName());
		result.setCode(discountProduct.getCode());
		result.setQuantity(discountProduct.getQuantity());
		result.setApplyDay(discountProduct.getApplyDay());
		result.setExpiration(discountProduct.getExpiration());
		result.setMoneyLimit(discountProduct.getMoneyLimit());
		
		discountService.save(result);
		
		return "redirect:/admin/discount";
	}
	
	@GetMapping("/admin/discount/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		DiscountProduct result = discountService.findById(id);
		discountService.delete(result);
		
		return "redirect:/admin/discount";
	}
	
	
	
	
	
}
