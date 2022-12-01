package datn.udpm.controller.customer;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomerHomeController {
	@RequestMapping({"home/index","/"})
	public String getHome( ) {
		return "redirect:/product/list";
	}
}
