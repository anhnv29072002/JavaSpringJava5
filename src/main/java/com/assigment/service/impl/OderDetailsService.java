package com.assigment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.OderDetails;
import com.assigment.repository.IOderDetalsRepository;
import com.assigment.service.IOderDetailsService;

@Service
public class OderDetailsService implements IOderDetailsService {

	@Autowired
	private IOderDetalsRepository repository;

	@Override
	public OderDetails insert(OderDetails oderDetails) {
		oderDetails.setId(null);
		return this.repository.save(oderDetails);
	}

	@Override
	public OderDetails update(OderDetails oderDetails) {
		Integer id = oderDetails.getId();
		if (id != null) {
			Optional<OderDetails> optOD = this.repository.findById(id);
			if (optOD.isPresent() == true) {
				return this.repository.save(oderDetails);
			}
		}
		return null;
	}

	@Override
	public OderDetails deleteById(Integer id) {
		if (id != null) {
			Optional<OderDetails> optOD = this.repository.findById(id);
			if (optOD.isPresent() == true) {
				this.repository.deleteById(id);
				return optOD.get();
			}
		}
		return null;
	}

	@Override
	public OderDetails getById(Integer id) {
		if (id != null) {
			Optional<OderDetails> optOD = this.repository.findById(id);
			if (optOD.isPresent() == true) {
				this.repository.deleteById(id);
				return optOD.get();
			}
		}
		return null;
	}

	@Override
	public List<OderDetails> getAll() {
		return this.repository.findAll();
	}

}
