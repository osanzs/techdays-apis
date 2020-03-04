package com.atsistemas.techday.controller3;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techday.generated.api.TechdayApi;
import com.techday.generated.model.EmployeeRequest;
import com.techday.generated.model.EmployeeResponse;

@RestController
@RequestMapping("example3")
public class TechdayAPIController3  implements TechdayApi{

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public ResponseEntity<EmployeeResponse> addEmployeeTechday(@Pattern(regexp = "^[0-9]+$") @Size(max = 3) String id,
			@Valid EmployeeRequest employeeRequest) {
		ResponseEntity<EmployeeResponse> response = this.restTemplate.exchange(
				RequestEntity
						.post(URI.create("http://localhost:8090/example3/techday/"+id+"/employees"))
						.contentType(MediaType.APPLICATION_JSON)
						.body(employeeRequest),
						EmployeeResponse.class);
		return response;
	}

	@Override
	public ResponseEntity<EmployeeResponse> getEmployeeTechday(
			@Pattern(regexp = "^[0-9_]+$") @Size(max = 150) String uuid,
			@Pattern(regexp = "^[0-9]+$") @Size(max = 3) String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> removeEmployeeTechday(@Pattern(regexp = "^[0-9_]+$") @Size(max = 150) String uuid,
			@Pattern(regexp = "^[0-9]+$") @Size(max = 3) String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
