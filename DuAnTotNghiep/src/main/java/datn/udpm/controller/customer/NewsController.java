package datn.udpm.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import datn.udpm.entity.News;
import datn.udpm.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	NewsService newsService ;
	
	@GetMapping("/news/list")
	public String list(Model model) {
		List<News> list = newsService.findAll();
		model.addAttribute("listNews",list);
		
		
		return "customer/news/list";
	}
}
