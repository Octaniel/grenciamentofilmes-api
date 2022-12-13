package com.octa.grenciamentofilmesapi.security.util;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class EmailProperties {

    @NotNull
    private String remetenteEmail ="igf@mf.gov.st";
        
    @NotNull
    private String remetenteNome="Inspeção Geral Das Finanças";

	public String getRemetenteEmail() {
		return remetenteEmail;
	}

	public void setRemetenteEmail(String remetenteEmail) {
		this.remetenteEmail = remetenteEmail;
	}

	public String getRemetenteNome() {
		return remetenteNome;
	}

	public void setRemetenteNome(String remetenteNome) {
		this.remetenteNome = remetenteNome;
	}
      
}
