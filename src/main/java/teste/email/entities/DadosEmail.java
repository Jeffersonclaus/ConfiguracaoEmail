package teste.email.entities;

import java.io.Serializable;

public class DadosEmail implements Serializable{

	private static final long serialVersionUID = 1L;
	private String remetente;
	private String remetenteTexto;
	private String destinatario;
	private String assunto;
	private String textoEmail;
	
	public DadosEmail() {
		
	}

	public DadosEmail(String remetente, String remetenteTexto, String destinatario, String assunto, String textoEmail) {

		this.remetente = remetente;
		this.remetenteTexto = remetenteTexto;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.textoEmail = textoEmail;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getRemetenteTexto() {
		return remetenteTexto;
	}

	public void setRemetenteTexto(String remetenteTexto) {
		this.remetenteTexto = remetenteTexto;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTextoEmail() {
		return textoEmail;
	}

	public void setTextoEmail(String textoEmail) {
		this.textoEmail = textoEmail;
	}

}
