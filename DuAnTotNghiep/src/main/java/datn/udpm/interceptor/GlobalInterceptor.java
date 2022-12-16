package datn.udpm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import datn.udpm.entity.Account;
import datn.udpm.entity.Category;
import datn.udpm.entity.News;
import datn.udpm.entity.Order;
import datn.udpm.service.AccountService;
import datn.udpm.service.CategoryService;
import datn.udpm.service.NewsService;
import datn.udpm.service.OrderService;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
	
	@Autowired 
	CategoryService categoryService ;
	@Autowired
	AccountService accountService ;
	
	@Autowired
	OrderService orderService; 
	
	@Autowired
	NewsService newsService;
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		List<Category> listCategory = categoryService.findAll();
		request.setAttribute("listCategory", listCategory);
		
		
		String email = request.getRemoteUser();
		if(email == null) {
			Account account = new Account();
			account.setImage("user.jpg");
			request.setAttribute("account", account);
		}else {
			Account account =accountService.findByEmail(email);
			request.setAttribute("account", account);
		}
		
		
		List<News> listNew = newsService.findAll();
		request.setAttribute("listNew", listNew);
		
		
		Integer soLuongDonHangChuaDuyet = orderService.findByOrderNotApprove();
		
		request.setAttribute("count", soLuongDonHangChuaDuyet);
		
		List<Order> listOrderNotApprove = orderService.getListNamePeople();
		
		request.setAttribute("listOrder", listOrderNotApprove);
		
		
	}
	
	
	
	
}
