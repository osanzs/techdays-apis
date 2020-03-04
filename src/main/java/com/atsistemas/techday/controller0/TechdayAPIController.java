package com.atsistemas.techday.controller0;




import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.techday.dto.EmployeeRequest;
import com.atsistemas.techday.dto.EmployeeResponse;
import com.atsistemas.techday.service.TechdayService;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("example")
//@Slf4j
public class TechdayAPIController {

	private static Logger log = (Logger) LoggerFactory.getLogger(TechdayAPIController.class);
	
	@Autowired
	private TechdayService service;
	
	
	@PostMapping("/techday/{id}/employees")
	public ResponseEntity<EmployeeResponse> addEmployeeTechday(@PathVariable("id") String id,
			@RequestBody EmployeeRequest employeeRequest) {

		ResponseEntity<EmployeeResponse> response;
		
		log.info("Inicio de la operación registro en el Techday");
		log.info("IdTechaday"+id);
		log.info("Request"+employeeRequest.toString());
		
		EmployeeResponse data= service.addEmployee(employeeRequest);
		
		response= new ResponseEntity<EmployeeResponse>(data, HttpStatus.CREATED);
		
		return response;

	}

}
