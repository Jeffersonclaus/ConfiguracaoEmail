package teste.email.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import teste.email.entities.DadosEmail;

public class Email {

	
	public static void enviarEmail(DadosEmail dados, boolean enviarHtml) throws UnsupportedEncodingException {

		
		Properties props = new Properties();
		

		// Parâmetros de conexão com servidor Gmail

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("testeemailclaus@gmail.com", "*Testeemail1234");
			}
		});

		// Ativa Debug para sessão
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			
			// Remetente + opcional "seu nome", pois é como vai aparecer seu nome no
			// destinarios

			message.setFrom(new InternetAddress(dados.getRemetente(), dados.getRemetenteTexto())); // Remetente
																											// e como
																											// no email

			Address[] toUser = InternetAddress.parse(dados.getDestinatario()); // Destinatario
			message.setRecipients(Message.RecipientType.TO, toUser);

			// Método para enviar a mensagem criada

			message.setSubject(dados.getAssunto()); // Assunto
			// Texto do Email
	

			if (enviarHtml) {  //Se enviarHtml for true, o textoEmail vai ser no estilo html
			
				//Texto do Email 
				message.setContent(dados.getTextoEmail(), "text/html; charset=utf-8"); 
				
			}else {// Se não,  vai usar texto normal
				//Texto do Email
				message.setText(dados.getTextoEmail()); 
			}
			Transport.send(message);
			System.out.println("Enviado!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
