package com.atsistemas.techday.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techday.generated.model.EmployeeRequest;
import com.techday.generated.model.EmployeeResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.atsistemas.techday:techday-apis:+:stubs:8090")
@DirtiesContext
public class TechdayControllerCDCTest {
	
	 @Autowired 
	 MockMvc mvc;
	 
	@Test
	public void addEmployeeTest() throws Exception {

		EmployeeRequest request = new EmployeeRequest();
		request.setApellido1("Sanz");
		request.setApellido2("Sebastian");
		request.setNombre("Oscar");
		request.setSede("Madrid");
		request.setModalidad("Presencial");

		EmployeeResponse response = new EmployeeResponse();
		response.setApellido1("Sanz");
		response.setApellido2("Sebastian");
		response.setNombre("Oscar");
		response.setSede("Madrid");
		response.setModalidad("Presencial");
		response.setUuid("1113_33ad_333a");

		mvc.perform(post("/example3/techday/{id}/employees", 111).content(asJsonString(request))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.nombre", is(response.getNombre())))
				.andExpect(jsonPath("$.uuid", is(response.getUuid())));

	}

	public static String asJsonString(final Object obj) throws JsonProcessingException {

		return new ObjectMapper().writeValueAsString(obj);

	}

}
