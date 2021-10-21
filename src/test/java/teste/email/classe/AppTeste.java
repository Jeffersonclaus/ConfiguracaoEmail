package teste.email.classe;

import java.io.UnsupportedEncodingException;

import teste.email.entities.DadosEmail;
import teste.email.service.Email;

public class AppTeste {

	@org.junit.Test
	public  void TesteEmail() throws UnsupportedEncodingException { 
		StringBuilder sbEmail = new StringBuilder(); //teste git
		
		
		
		
		DadosEmail dados = new DadosEmail(
				"testeemailclaus@gmail.com",
				"JC - Desenvolvimento JAVA",
				"jeffersonclaus@gmail.com",
				"Enviando email com JavaMail",
				"Email ultilizando JavaMail");
		
		Email.enviarEmail(dados,true);
		
	
	}
		  

}
