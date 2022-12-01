package datn.udpm.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import datn.udpm.entity.Account;
import datn.udpm.service.AccountService;

@Controller
public class RegisterController {
	
	@Autowired
	AccountService accountService ;
	
	@GetMapping("/register/new")
	public String createRegisterForm(Model model) {
		
		Account account = new Account();
		model.addAttribute("accounts",account);
		return "customer/security/register";
	}
	
	@PostMapping("/register/save")
	public String saveRegisterForm(@ModelAttribute("account") Account account , Model model) {
		accountService.saveRegister(account);
		return "redirect:/register/new";
	}
	
}
