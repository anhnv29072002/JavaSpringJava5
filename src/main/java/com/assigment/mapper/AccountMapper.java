package com.assigment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.Account;
import com.assigment.model.AccountDTO;

@Service
public class AccountMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public Account convertToEntity(AccountDTO accountDTO) {
		Account account = this.mapper.map(accountDTO, Account.class);
		return account;
	}
	
	public AccountDTO convertToDTO(Account account) {
		AccountDTO accountDTO = this.mapper.map(account, AccountDTO.class);
		return accountDTO;
	}
	
	public Account convertToEntityTC(AccountDTO accountDTO) {
		Account account = new Account();
		account.setUsername(accountDTO.getUsername());
		account.setPassword(accountDTO.getPassword());
		account.setEmail(accountDTO.getEmail());
		account.setFullname(accountDTO.getFullname());
		account.setAdmin(accountDTO.getAdmin());
//		account.setPhoto(accountDTO.getPhoto().getOriginalFilename());
		return account;
	}
	
}
