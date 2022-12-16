package datn.udpm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import datn.udpm.entity.Category;
import datn.udpm.entity.Product;
import datn.udpm.entity.SubCategory;
import datn.udpm.service.CategoryService;
import datn.udpm.service.SubCategoryService;

@Controller
public class CategoryAdminController {
	
	@Autowired
	SubCategoryService subService;
	@Autowired
	CategoryService cateService;
	
	@GetMapping("admin/category")
	public String table(Model model) {
//		List<SubCategory> lstSub = subService.findAll();
//		model.addAttribute("lstSub", lstSub);
		return page(model, 0);
	}
	
	@GetMapping("admin/category/{page}")
	public String page(Model model, @PathVariable("page") int currentPage) {
		Page<SubCategory> page = subService.findPage(currentPage, 5);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listSub", page);
		return "admin/category/table";
	}
	
	
	@GetMapping("/admin/category/create")
	public String create(Model model, @ModelAttribute("category") SubCategory sub) {
		List<Category> lstCate = cateService.findAll();
		model.addAttribute("lstCate", lstCate);
		
		return "admin/category/create";
	}
	
	@PostMapping("/admin/category/save")
	public String save(@ModelAttribute("category") SubCategory sub) {
		subService.save(sub);
		
		return "redirect:/admin/category";
	}
	
	@GetMapping("/admin/category/edit/{id}")
	public String edit(@PathVariable("id") Integer id , Model model,
			@ModelAttribute("category") SubCategory sub) {
		sub = subService.findById(id);
		model.addAttribute("category", sub);
		return "admin/category/edit";
	}
	
	@PostMapping("/admin/category/update/{id}")
	public String update(@PathVariable("id") Integer id ,@ModelAttribute("category") SubCategory sub) {
		
		SubCategory subCate = subService.findById(id);
		sub.setId(id);
		sub.setCategory(subCate.getCategory());
		subService.save(sub);
		
		return "redirect:/admin/category";
	}
	
	@GetMapping("/admin/category/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		SubCategory sub = subService.findById(id);
		subService.delete(sub);
		
		return "redirect:/admin/category";
	}
}
