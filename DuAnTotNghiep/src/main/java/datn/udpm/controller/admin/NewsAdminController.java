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

import datn.udpm.entity.News;
import datn.udpm.service.NewsService;

@Controller
public class NewsAdminController {

	
	@Autowired
	NewsService newsService ;
	
	@RequestMapping("/admin/news")
	public String list(Model model) {
		
		List<News> list = newsService.findAll();
		model.addAttribute("list",list);
		
		
		return "admin/news/table";
	}
	
	@GetMapping("/admin/news/create")
	public String create(Model model) {
		News news = new News();
		model.addAttribute("news",news);
		return "admin/news/create";
	}
	@PostMapping("/admin/news/save")
	public String save(@ModelAttribute("news") News news,Model model) {
		
		newsService.save(news);
		
		return "redirect:/admin/news";
	}
	@GetMapping("/admin/news/edit/{id}")
	public String edit(@PathVariable("id") Integer id ,Model model) {
		News news = newsService.findById(id);
		model.addAttribute("news",news);
		return "admin/news/edit";
	}
	@PostMapping("/admin/news/update/{id}")
	public String update(@PathVariable("id") Integer id,@ModelAttribute("news") News news,Model model) {
		News result = newsService.findById(id);
		result.setContent(news.getContent());
		result.setCreateDate(news.getCreateDate());
		result.setAuthor(news.getAuthor());
		result.setSumary(news.getSumary());
		result.setTitle(news.getTitle());
		newsService.save(news);
		
		return "redirect:/admin/news";
	}
	
	@GetMapping("/admin/news/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		News result = newsService.findById(id);
		newsService.delete(result);
		
		return "redirect:/admin/news";
	}
	
}
