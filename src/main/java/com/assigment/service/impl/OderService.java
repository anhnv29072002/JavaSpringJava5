package com.assigment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.Oder;
import com.assigment.repository.IOderRepository;
import com.assigment.service.IOderService;

@Service
public class OderService implements IOderService {

	@Autowired
	private IOderRepository repository;

	@Override
	public Oder insert(Oder oder) {
		oder.setId(null);
		return this.repository.save(oder);
	}

	@Override
	public Oder update(Oder oder) {
		Integer id = oder.getId();
		if (id != null) {
			Optional<Oder> optOder = this.repository.findById(id);
			if (optOder.isPresent() == true) {
				return this.repository.save(oder);
			}
		}
		return null;
	}

	@Override
	public Oder deleteById(Integer id) {
		if (id != null) {
			Optional<Oder> optOder = this.repository.findById(id);
			if (optOder.isPresent() == true) {
				this.repository.deleteById(id);
				return optOder.get();
			}
		}
		return null;
	}

	@Override
	public Oder getById(Integer id) {
		if (id != null) {
			Optional<Oder> optOder = this.repository.findById(id);
			if (optOder.isPresent() == true) {
				return optOder.get();
			}
		}
		return null;
	}

	@Override
	public List<Oder> getAll() {
		return this.repository.findAll();
	}

}
