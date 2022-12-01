package datn.udpm.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import datn.udpm.entity.Account;
import datn.udpm.respository.AccountRepository;
import datn.udpm.service.AccountService;
@Service
public class AccountServiceImple implements AccountService {
	
	@Autowired
	AccountRepository accountRepo ;
	
	@Override
	public Account findByEmail(String email) {
		return accountRepo.findById(email).get();
	}

	@Override
	public Account saveRegister(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account save(Account result) {
		return accountRepo.save(result);
	}

}
