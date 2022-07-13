package com.assigment.service;

import java.util.List;

import com.assigment.entity.OderDetails;

public interface IOderDetailsService {

	public OderDetails insert(OderDetails oderDetails);

	public OderDetails update(OderDetails oderDetails);

	public OderDetails deleteById(Integer id);

	public OderDetails getById(Integer id);

	public List<OderDetails> getAll();
	
}
