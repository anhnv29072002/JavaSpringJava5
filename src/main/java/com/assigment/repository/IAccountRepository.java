package com.assigment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer>{

}
