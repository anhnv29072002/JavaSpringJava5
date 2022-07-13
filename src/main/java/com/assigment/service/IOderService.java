package com.assigment.service;

import java.util.List;

import com.assigment.entity.Oder;

public interface IOderService {

	public Oder insert(Oder oder);

	public Oder update(Oder oder);

	public Oder deleteById(Integer id);

	public Oder getById(Integer id);
	
	public List<Oder> getAll();

}
