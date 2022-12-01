package datn.udpm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {
	@RequestMapping("/admin/dashboard")
	public String home() {
		return "admin/layout/dashboard";
	}
}
