package datn.udpm.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroduceController {
	@GetMapping("/introduce/information")
	public String introduce() {
		
		return "customer/introduce/information";
	}
}
