package teste.email.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.DocumentException;

import teste.email.entities.DadosEmail;

public class Email {

	public static void enviarEmail(DadosEmail dados, boolean enviarHtml) throws IOException, DocumentException {

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

			// Assunto Texto do Email
			message.setSubject(dados.getAssunto());

			// Criar Email com anexo
			/* Parte 1: Do email que é texto e a drescrição do e-mail */

			MimeBodyPart corpoEmail = new MimeBodyPart();

			if (enviarHtml) { // Se enviarHtml for true, o textoEmail vai ser no estilo html

				// Texto do Email

				corpoEmail.setContent(dados.getTextoEmail(), "text/html; charset=utf-8");

			} else {// Se não, vai usar texto normal
					// Texto do Email
				corpoEmail.setText(dados.getTextoEmail());
			}
			
			//Lista de anexos e cria o anexos
			List<FileInputStream> listaAnexo = new ArrayList<FileInputStream>();

			listaAnexo.add(GeradorPDF.simuladordePDF()); // simular um lista de anexos
			listaAnexo.add(GeradorPDF.simuladordePDF());
			listaAnexo.add(GeradorPDF.simuladordePDF());
			listaAnexo.add(GeradorPDF.simuladordePDF());

			//add parte 1 com parte 2
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(corpoEmail);
		
			
			int i = 1;
			
			//recorre toda a lista e add os anexos
			for (FileInputStream FileInputStream : listaAnexo) {
				MimeBodyPart anexoEmail = new MimeBodyPart();
						
				anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(FileInputStream, "application/pdf")));
				anexoEmail.setFileName("anexo"+ i+ ".pdf");
				mp.addBodyPart(anexoEmail);

				i ++;
			}
		
			message.setContent(mp);

			Transport.send(message);
			System.out.println("Enviado!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
