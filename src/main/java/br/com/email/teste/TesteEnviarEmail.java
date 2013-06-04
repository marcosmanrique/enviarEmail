package br.com.email.teste;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import br.com.email.service.Email;
import br.com.email.service.impl.EmailImpl;
import br.com.email.template.TemplateEmail;

public class TesteEnviarEmail {
	
	public static void main(String[] args) {

		TemplateEmail template = new TemplateEmail();
		template.setSmtp("smtp.gmail.com");
		template.setPortaSmtp(587);
		template.setEmailRemetente("testeRemetente@gmail.com");
		template.setNomeRemetente("nome");
		template.setMensagem("<html>Corpo do email. <br/>Assinatura email.</html>");
		template.setAssunto("Teste Email Assunto");
		template.setConta("usuario");
		template.setSenha("senha");
		try {
			template.addEmailDestinatario(new InternetAddress("testeDestinatario@gmail.com"));
		} catch (AddressException e) {
			e.printStackTrace();
		}
		
		Email email = new EmailImpl();
		email.enviarEmailHtml(template);
	}
}
