package com.atsistemas.techday.service;

import com.atsistemas.techday.dto.EmployeeRequest;
import com.atsistemas.techday.dto.EmployeeResponse;

public interface TechdayService {

	public EmployeeResponse addEmployee(EmployeeRequest request);
}
