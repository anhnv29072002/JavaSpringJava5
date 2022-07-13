package com.assigment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.OderDetails;
import com.assigment.model.OderDetailsDTO;

@Service
public class OderDetailsMapper {

	@Autowired
	private ModelMapper mapper;
	
	public OderDetails convertToEntity(OderDetailsDTO oderDetailsDTO) {
		OderDetails oderDetails = this.mapper.map(oderDetailsDTO, OderDetails.class);
		return oderDetails;
	}
	
	public OderDetailsDTO convertToDTO(OderDetails oderDetails) {
		OderDetailsDTO oderDetailsDTO = this.mapper.map(oderDetails, OderDetailsDTO.class);
		return oderDetailsDTO;
	}
	
}
