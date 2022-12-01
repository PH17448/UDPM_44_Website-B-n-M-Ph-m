package datn.udpm.service;

import datn.udpm.entity.Account;

public interface AccountService {
	public Account findByEmail(String email);

	public Account saveRegister(Account account);

	public Account save(Account result);
}
