package teste.email.classe;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import teste.email.entities.DadosEmail;
import teste.email.service.Email;

public class AppTeste {

	@org.junit.Test
	public  void TesteEmail() throws IOException, DocumentException { 
		// Para escrever Texte do emailem HTML
		StringBuilder sbEmail = new StringBuilder(); 
		sbEmail.append("<h4> olá!!! <br/><br/>");
		sbEmail.append("<h4>Você está recebendo o acesso ao link curso de Java da JC - Desenvolvimento JAVA.</h4> <br/>");
		sbEmail.append("<h2>Clique no botão para acessar o Link do Github:<br/>");
		sbEmail.append("<a href=\"https://github.com/Jeffersonclaus\"><button>Clique aqui</button></a> <br/>");
		sbEmail.append("<h3><span style=\"font-size:14px\"> Ass.: Jefferson Claus</span><h3/>");
		
		
		
		
		DadosEmail dados = new DadosEmail(
				"testeemailclaus@gmail.com",
				"Jefferson Claus - Desenvolvimento JAVA",
				"jeffersonclaus@gmail.com",
				"Enviando email com JavaMail.",
				sbEmail.toString());
		
		Email.enviarEmail(dados,true);
		
	
	}
		  

}
