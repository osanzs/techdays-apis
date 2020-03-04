package com.atsistemas.techday.service.impl;

import org.springframework.stereotype.Service;

import com.atsistemas.techday.dto.EmployeeRequest;
import com.atsistemas.techday.dto.EmployeeResponse;
import com.atsistemas.techday.service.TechdayService;

@Service
public class TechdayServiceImpl implements TechdayService{

	@Override
	public EmployeeResponse addEmployee(EmployeeRequest request) {
		
		EmployeeResponse response= new EmployeeResponse();
		response.setApellido1(request.getApellido1());
		response.setApellido2(request.getApellido2());
		response.setNombre(request.getNombre());
		response.setSede(request.getSede());
		response.setModalidad(request.getModalidad());
		response.setUuid("1113_33ad_333a");
		
		return response;
		
		
	}

}
