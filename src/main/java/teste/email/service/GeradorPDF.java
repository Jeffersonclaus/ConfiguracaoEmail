package teste.email.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorPDF {
	
	
	//Metodo para Gerar PDF 
	public static FileInputStream simuladordePDF() throws IOException, DocumentException {
		
	Document document = new Document();
	File file = new File("testePDF.pdf");// nome do arquivo PDF
	file.createNewFile(); //cria o arquivo!
	PdfWriter.getInstance(document, new FileOutputStream(file)); // pega o arquivo
	document.open();
	document.add(new Paragraph("Conteudo de teste do texto PDF com JAVA MAIL")); //escreve
	document.close();
	
	return new FileInputStream(file);
	
		
	}
	
	
	

}
