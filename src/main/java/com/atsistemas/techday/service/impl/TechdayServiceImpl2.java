package com.atsistemas.techday.service.impl;

import org.springframework.stereotype.Service;


import com.atsistemas.techday.service.TechdayService2;
import com.techday.generated.model.EmployeeRequest;
import com.techday.generated.model.EmployeeResponse;

@Service
public class TechdayServiceImpl2 implements TechdayService2{

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
