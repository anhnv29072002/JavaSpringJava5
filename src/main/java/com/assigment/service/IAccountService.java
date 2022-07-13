package com.assigment.service;

import java.util.List;

import com.assigment.entity.Account;

public interface IAccountService {

	public Account insert(Account account);

	public Account update(Account account);

	public Account deleteById(Integer id);

	public Account getById(Integer id);
	
	public List<Account> getAll();

}
