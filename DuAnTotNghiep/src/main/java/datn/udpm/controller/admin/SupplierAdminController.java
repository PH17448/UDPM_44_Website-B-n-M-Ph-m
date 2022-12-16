package datn.udpm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import datn.udpm.entity.Supplier;
import datn.udpm.service.SupplierService;

@Controller
public class SupplierAdminController {
	
	@Autowired
	SupplierService supplierService ;
	
	@RequestMapping("/admin/supplier")
	public String list(Model model) {		
		List<Supplier> list = supplierService.findAll();
		model.addAttribute("list",list);
		
		return "admin/supplier/table";
	}
	
	@GetMapping("/admin/supplier/create")
	public String create(Model model) {
		Supplier supplier = new Supplier();
		model.addAttribute("supplier", supplier);
		
		return "admin/supplier/create";
	}
	
	@PostMapping("/admin/supplier/save")
	public String save(@ModelAttribute("supplier") Supplier supplier, Model model) {
		
		supplierService.save(supplier);
		
		return "redirect:/admin/supplier";
	}
	
	@GetMapping("/admin/supplier/edit/{id}")
	public String edit(@PathVariable("id") Integer id ,Model model) {
		Supplier supplier = supplierService.findById(id);
		model.addAttribute("supplier", supplier);
		return "admin/supplier/edit";
	}
	
	@PostMapping("/admin/supplier/update/{id}")
	public String update(
		@PathVariable("id") Integer id,
		@ModelAttribute("supplier") Supplier supplier,
		Model model
	) {
		Supplier result = supplierService.findById(id);
		
		result.setName(supplier.getName());
		result.setCompanyName(supplier.getCompanyName());
		result.setLogo(supplier.getLogo());
		result.setWebUrl(supplier.getWebUrl());
		result.setProductType(supplier.getProductType());
		result.setPersonContact(supplier.getPersonContact());
		result.setAddress1(supplier.getAddress1());
		result.setAddress2(supplier.getAddress2());
		result.setCity(supplier.getCity());
		result.setCountry(supplier.getCountry());
		result.setPostalCode(supplier.getPostalCode());
		result.setTelephone(supplier.getTelephone());
		result.setEmail(supplier.getEmail());
		
		supplierService.save(supplier);
		
		return "redirect:/admin/supplier";
	}
	
	@GetMapping("/admin/supplier/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {		
		Supplier result = supplierService.findById(id);
		supplierService.delete(result);
		
		return "redirect:/admin/supplier";
	}
}
