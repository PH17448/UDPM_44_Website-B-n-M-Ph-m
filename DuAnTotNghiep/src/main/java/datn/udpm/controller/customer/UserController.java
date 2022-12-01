package datn.udpm.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import datn.udpm.entity.Account;
import datn.udpm.service.AccountService;

@Controller
public class UserController {
	
	@Autowired
	AccountService accountService ;
	
	@GetMapping("/account/edit")
	public String edit( Model model , HttpServletRequest request) {
		
		String email = request.getRemoteUser();
		Account account = accountService.findByEmail(email);
		model.addAttribute("account",account);
		return "customer/userInformation/form";
	}
	
	@PostMapping("/account/update")
	public String update(@ModelAttribute("account") Account account , Model model , HttpServletRequest request) {
		
		String email = request.getRemoteUser();
		Account result = accountService.findByEmail(email);
		result.setPassword(account.getPassword());
		result.setFullname(account.getFullname());
		result.setPhone(account.getPhone());
		result.setAddress(account.getAddress());
		result.setImage(account.getImage());
		
		accountService.save(result);
		
		return "redirect:/account/edit";
	}
	
}
