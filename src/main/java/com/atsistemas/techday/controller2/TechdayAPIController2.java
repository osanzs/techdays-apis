package com.atsistemas.techday.controller2;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.techday.controller0.TechdayAPIController;
import com.atsistemas.techday.service.TechdayService2;
import com.techday.generated.api.TechdayApi;
import com.techday.generated.model.EmployeeResponse;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@RestController
//@Slf4j
@RequestMapping("example2")
public class TechdayAPIController2 implements TechdayApi {

	private static Logger log = (Logger) LoggerFactory.getLogger(TechdayAPIController2.class);
	
	
	@Autowired
	private TechdayService2 service;

	@Override
	public ResponseEntity<com.techday.generated.model.EmployeeResponse> addEmployeeTechday(
			@Pattern(regexp = "^[0-9]+$") @Size(max = 3) String id,
			com.techday.generated.model.@Valid EmployeeRequest employeeRequest) {
		
		ResponseEntity<EmployeeResponse> response;

		log.info("Inicio de la operación registro en el Techday");
		log.info("IdTechaday" + id);
		log.info("Request" + employeeRequest.toString());

		EmployeeResponse data = service.addEmployee(employeeRequest);

		response = new ResponseEntity<EmployeeResponse>(data, HttpStatus.CREATED);

		return response;
	}

	@Override
	public ResponseEntity<com.techday.generated.model.EmployeeResponse> getEmployeeTechday(
			@Pattern(regexp = "^[0-9_]+$") @Size(max = 150) String uuid,
			@Pattern(regexp = "^[0-9]+$") @Size(max = 3) String id) {

		return null;
	}

	@Override
	public ResponseEntity<Void> removeEmployeeTechday(@Pattern(regexp = "^[0-9_]+$") @Size(max = 150) String uuid,
			@Pattern(regexp = "^[0-9]+$") @Size(max = 3) String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
