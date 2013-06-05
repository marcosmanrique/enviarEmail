package br.com.email.teste;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import br.com.email.dto.EmailDTO;
import br.com.email.service.Email;
import br.com.email.service.impl.EmailImpl;

public class TesteEnviarListaEmails {
	
	public static void main(String[] args) {

		EmailDTO template = new EmailDTO();
		template.setSmtp("smtp.gmail.com");
		template.setPortaSmtp(587);
		template.setEmailRemetente("emailRemetente@gmail.com");
		template.setNomeRemetente("nome");
		template.setMensagem("<html>Corpo do email 1. <br/>Assinatura email 1.</html>");
		template.setAssunto("email Email Assunto 1");
		template.setConta("usuario");
		template.setSenha("senha");
				
		EmailDTO template1 = new EmailDTO();
		template1.setSmtp("smtp.gmail.com");
		template1.setPortaSmtp(587);
		template.setEmailRemetente("emailRemetente@gmail.com");
		template.setNomeRemetente("nome");
		template.setMensagem("<html>Corpo do email 2. <br/>Assinatura email 2.</html>");
		template.setAssunto("Teste Email Assunto 2");
		template.setConta("usuario");
		template.setSenha("senha");
		try {
			template.addEmailDestinatario(new InternetAddress("emailDestinatario@gmail.com"));
			template1.addEmailDestinatario(new InternetAddress("emailDestinatario@gmail.com"));
		} catch (AddressException e) {
			e.printStackTrace();
		}
		List<EmailDTO> listaEmails = new ArrayList<EmailDTO>();
		listaEmails.add(template);
		listaEmails.add(template1);
		
		Email email = new EmailImpl();
		email.enviarListaEmailsHtml(listaEmails);
	}
}
