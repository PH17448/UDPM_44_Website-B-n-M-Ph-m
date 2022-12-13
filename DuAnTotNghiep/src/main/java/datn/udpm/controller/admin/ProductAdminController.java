package datn.udpm.controller.admin;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import datn.udpm.entity.DiscountProduct;
import datn.udpm.entity.Product;
import datn.udpm.entity.SubCategory;
import datn.udpm.entity.Supplier;
import datn.udpm.service.DiscountService;
import datn.udpm.service.ProductService;
import datn.udpm.service.SubCategoryService;
import datn.udpm.service.SupplierService;

@Controller
public class ProductAdminController {
	@Autowired
	ProductService proService;
	@Autowired
	SubCategoryService subService;
	@Autowired
	SupplierService supService;
	@Autowired
	DiscountService disService;
	
	@GetMapping("admin/product")
	public String table( Model model) {
		
//		model.addAttribute("listPro",proService.findAll());
		
		return getPage(model, 0); //"admin/product/table"
	}
	@GetMapping("admin/product/{page}")
	public String getPage( Model model, @PathVariable("page") int currentPage) {
		Page<Product> page = proService.findPage(currentPage, 5);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listPro", page);
		
		return "admin/product/table";
	}
	
	
	@GetMapping("/admin/product/create")
	public String create(Model model, @ModelAttribute("product") Product product) {
		List<SubCategory> lstSub = subService.findAll();
		List<Supplier> lstSup = supService.findAll();
		List<DiscountProduct> lstDis = disService.findAll();
		model.addAttribute("lstSub", lstSub);
		model.addAttribute("lstSup", lstSup);
		model.addAttribute("lstDis", lstDis);
		
		return "admin/product/create";
	}
	
	@PostMapping("/admin/product/save")
	public String save(@ModelAttribute("product") Product product) {
		proService.save(product);
		
		return "redirect:/admin/product";
	}
	
	@GetMapping("/admin/product/edit/{id}")
	public String edit(@PathVariable("id") Integer id , Model model,
			@ModelAttribute("product") Product product) {
		product = proService.findById(id);
		model.addAttribute("product", product);
		return "admin/product/edit";
	}
	
	@PostMapping("/admin/product/update/{id}")
	public String update(@PathVariable("id") Integer id ,@ModelAttribute("product") Product product) {
		
		Product pro = proService.findById(id);
		product.setSubCategory(pro.getSubCategory());
		product.setSupplier(pro.getSupplier());
		product.setDiscount(pro.getDiscount());
		product.setCreateDate(new Date());
		proService.save(product);
		
		return "redirect:/admin/product";
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		Product pro = proService.findById(id);
		proService.delete(pro);
		
		return "redirect:/admin/product";
	}
	
//	@GetMapping("/admin/product/promotion")
//	public String promo(Model model, @ModelAttribute("product") Product product) {
//		List<Product> pro = proService.findAll();
//
//		return "admin/product/promotion";
//	}
}
