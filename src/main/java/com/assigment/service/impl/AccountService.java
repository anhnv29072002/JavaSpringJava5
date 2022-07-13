package com.assigment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.Account;
import com.assigment.repository.IAccountRepository;
import com.assigment.service.IAccountService;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;

	@Override
	public Account insert(Account account) {
		account.setId(null);
		return this.repository.save(account);
	}

	@Override
	public Account update(Account account) {
		Integer id = account.getId();
		if (id != null) {
			Optional<Account> optAccount = this.repository.findById(id);
			if (optAccount.isPresent() == true) {
				return this.repository.save(account);
			}
		}
		return null;
	}

	@Override
	public Account deleteById(Integer id) {
		if (id != null) {
			Optional<Account> optAccount = this.repository.findById(id);
			if (optAccount.isPresent() == true) {
				this.repository.deleteById(id);
				return optAccount.get();
			}
		}
		return null;
	}

	@Override
	public Account getById(Integer id) {
		if (id != null) {
			Optional<Account> optAccount = this.repository.findById(id);
			if (optAccount.isPresent() == true) {
				return optAccount.get();
			}
		}
		return null;
	}

	@Override
	public List<Account> getAll() {
		return this.repository.findAll();
	}

}
