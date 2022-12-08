package datn.udpm.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import datn.udpm.entity.Order;
import datn.udpm.entity.OrderDetail;
import datn.udpm.entity.Product;
import datn.udpm.entity.Voucher;
import datn.udpm.service.AccountService;
import datn.udpm.service.OrderDetailService;
import datn.udpm.service.OrderService;
import datn.udpm.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	AccountService accountService ;
	
	@Autowired
	OrderService orderService ;
	
	@Autowired
	OrderDetailService orderDetailService ;
	
	@Autowired
	ProductService productService ;
	@RequestMapping("/order/checkout")
	public String checkout( Model model) {
		
		return "customer/order/checkout";
	}
	
	
	@RequestMapping("/order/list")
	public String list(Model model ,HttpServletRequest request) {
		String email = request.getRemoteUser();
		List<Order> orderList = orderService.findByEmail(email);
		model.addAttribute("orders",orderList);
		
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getVoucher().getCode().equals("")) {
				model.addAttribute("message","Không");
			}else {
				model.addAttribute("message",orderList.get(i).getVoucher().getCode());
			}
		}
		
		return "customer/order/list";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Integer id , Model model) {
		double tongTien = 0 ;
		
		Order order = orderService.findById(id);
		
		
		model.addAttribute("order",order);
		List<OrderDetail> listOrderDetail = order.getOrderDetails();
		
		Voucher voucher = order.getVoucher();
		
		for (int i = 0; i < listOrderDetail.size(); i++) {
			OrderDetail orderDetail1 = listOrderDetail.get(i);
			OrderDetail orderDetail2 = orderDetailService.findById(orderDetail1.getId());
			Double donGia = orderDetail2.getPrice();
			Integer soLuong = orderDetail2.getQuantity();
			
			tongTien += (donGia*soLuong) ;
		}
		double moneyAfterVoucher = tongTien - voucher.getDiscount();
		
		model.addAttribute("moneyAfterVoucher",moneyAfterVoucher);
		model.addAttribute("discountVoucher",voucher.getDiscount());
		model.addAttribute("total",tongTien);
		return "customer/order/detail";
	}
	
	@GetMapping("/order/cancel/{id}")
	public String cancel(@PathVariable("id") Integer id) {
		Order order = orderService.findById(id);
		order.setStatus(2);
		orderService.save(order);
		return "redirect:/order/list";
	}
	
	
	
	
}
