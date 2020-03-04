org.springframework.cloud.contract.spec.Contract.make {

	description("""
        Ejemplo para registrar empleados en el Techday
    """)
	request {
		method POST()
		url "/example3/techday/111/employees"
		body(
			nombre: "Oscar", 
			apellido1: "Sanz", 
			apellido2: "Sebastian",
			sede: "Madrid",
			modalidad: "Presencial"
			)
		headers {
			contentType(applicationJson())
				}
	}
	response {
		status 201
		body("""
            {
				"uuid": "1113_33ad_333a",
				"nombre": "Oscar",
				"apellido1": "Sanz",
				"apellido2": "Sebastian",
				"sede": "Madrid",
				"modalidad": "Presencial"
			}
        """)
		headers {
			contentType(applicationJson())
		}
	}
	
	
}