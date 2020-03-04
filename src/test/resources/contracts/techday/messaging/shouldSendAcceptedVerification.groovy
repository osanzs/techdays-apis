org.springframework.cloud.contract.spec.Contract.make {
	description("""
        Ejemplo para registrar empleados en el Techday
    """)
	label "accepted_verification"
	outputMessage {
		sentTo "verifications"
		body(eligible: true)
		headers {
			header("contentType", applicationJsonUtf8())
		}
	}
}