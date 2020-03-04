package com.atsistemas.techday.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.atsistemas.techday.service.TechdayService2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techday.generated.model.EmployeeRequest;
import com.techday.generated.model.EmployeeResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TechdayControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TechdayService2 service;

	@Test
	public void addEmployeeTest() throws Exception {

		EmployeeRequest request= new EmployeeRequest();
		request.setApellido1("Sanz");
		request.setApellido2("Sebastian");
		request.setNombre("Oscar");
		request.setSede("Madrid");
		request.setModalidad("Presencial");
		
		EmployeeResponse response= new EmployeeResponse();
		response.setApellido1("Sanz");
		response.setApellido2("Sebastian");
		response.setNombre("Oscar");
		response.setSede("Madrid");
		response.setModalidad("Presencial");
		response.setUuid("1113_33ad_333a");
		
		given(service.addEmployee(request)).willReturn(response);

		mvc.perform(
				post("/example2/techday/{id}/employees/",123)
				.content(asJsonString(request))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.nombre", is(response.getNombre())))
				.andExpect(jsonPath("$.uuid", is(response.getUuid())));

	}

	
	public static String asJsonString(final Object obj) throws JsonProcessingException {
	    
	        return new ObjectMapper().writeValueAsString(obj);
	    
	}

}
