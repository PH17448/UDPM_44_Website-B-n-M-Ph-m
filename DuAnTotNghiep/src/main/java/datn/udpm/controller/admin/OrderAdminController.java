package datn.udpm.controller.admin;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import datn.udpm.entity.Order;
import datn.udpm.entity.OrderDetail;
import datn.udpm.entity.PaymentHistory;
import datn.udpm.service.OrderDetailService;
import datn.udpm.service.OrderService;
import datn.udpm.service.PaymentHistoryService;

@Controller
public class OrderAdminController {
	
	@Autowired
	OrderService orderService ;
	
	@Autowired
	OrderDetailService orderDetailService ;
	
	@Autowired
	PaymentHistoryService paymentHistoryService ;
	
	@GetMapping("/admin/order/list")
	public String list(Model model) {
		
		model.addAttribute("listOrder",orderService.findAll());
		
		return "admin/order/table";
	}
	
	
	
	
	
	
	
	@GetMapping("/admin/order/repoOrder")
	public String repoOrder(Model model) {
		List<PaymentHistory> list = paymentHistoryService.findAll();
		model.addAttribute("list",list);
		return "admin/order/repoOrder";
	}
	
	@GetMapping("/admin/order/repoOrder/save/{id}")
	public String saveOrderRepo(@PathVariable("id") Integer id,Model model) {
		double tongTien = 0 ;
		Order order = orderService.findById(id);
		
		order.setStatus(4);
		orderService.save(order);
		
		PaymentHistory paymentHistory = new PaymentHistory();
		paymentHistory.setOrder(order);
		paymentHistory.setPaymentDate(new Date());
		paymentHistory.setPaymentHistory(order.getPayment());
		paymentHistory.setStatus(1);
		
		List<OrderDetail> list = order.getOrderDetails();
		for (int i = 0; i < list.size(); i++) {
			OrderDetail orderDetail = list.get(i);
			OrderDetail orderDetail2 = orderDetailService.findById(orderDetail.getId());
			Double donGia = orderDetail2.getPrice();
			Integer soLuong = orderDetail2.getQuantity();
			tongTien += donGia*soLuong ;
		}
		paymentHistory.setTotalMoney(tongTien);
		paymentHistoryService.save(paymentHistory);
		return "redirect:/admin/order/list";
	}
	
	
	
	
	@GetMapping("/admin/order/detail/{id}")
	public String detail(@PathVariable("id") Integer id , Model model) {
		
		Order order = orderService.findById(id);
		model.addAttribute("order",order);
		return "admin/order/detail";
	}
	
	
	
	
	
	
	
	@GetMapping("/admin/order/confirm/{id}")
	public String confirm( @PathVariable("id") Integer id,Model model) {
		
		Order order = orderService.findById(id);
		
		order.setStatus(1);
		orderService.save(order);
		
		return "redirect:/admin/order/list";
	}
	@GetMapping("/admin/order/delivery/{id}")
	public String delivery(@PathVariable("id") Integer id , Model model) {
		Order order = orderService.findById(id);
		order.setStatus(3);
		orderService.save(order);
		return "redirect:/admin/order/list";
	}
}
