package com.assigment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.Oder;
import com.assigment.model.OderDTO;

@Service
public class OderMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public Oder convertToEntity(OderDTO oderDTO) {
		Oder oder = this.mapper.map(oderDTO, Oder.class);
		return oder;
	}
	
	public OderDTO convertToDTO(Oder oder) {
		OderDTO oderDTO = this.mapper.map(oder, OderDTO.class);
		return oderDTO;
	}
	
}
