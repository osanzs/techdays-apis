package com.atsistemas.techday.controller1;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.techday.controller0.TechdayAPIController;
import com.atsistemas.techday.dto.EmployeeRequest;
import com.atsistemas.techday.dto.EmployeeResponse;
import com.atsistemas.techday.service.TechdayService;
import com.techday.generated.model.TokenResponseForbidden;
import com.techday.generated.model.TokenResponseUnauthorized;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
//@Slf4j
@RequestMapping("example1")
@Api(value = "techday", description = "the techday API")
public class TechdayAPIController1 {

	private static Logger log = (Logger) LoggerFactory.getLogger(TechdayAPIController1.class);
	
	
	@Autowired
	private TechdayService service;
	
	@ApiOperation(value = "Incluir un empleado en el techday", response = EmployeeResponse.class)
	@ApiResponses(value = { 
		        @ApiResponse(code = 201, message = "Operación realizada con exito.", response = EmployeeResponse.class),
		        @ApiResponse(code = 401, message = "No Autorizado", response = TokenResponseUnauthorized.class),
		        @ApiResponse(code = 404, message = "Acceso prohibido", response = TokenResponseForbidden.class) })  
	@PostMapping("/techday/{id}/employees")
	public ResponseEntity<EmployeeResponse> addEmployeeTechday(@Pattern(regexp="^[0-9]+$") @Size(max=3)@ApiParam(value = "",required=true ) @Valid @PathVariable("id") String id,
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
