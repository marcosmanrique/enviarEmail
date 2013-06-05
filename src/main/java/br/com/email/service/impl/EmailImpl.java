package br.com.email.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

import br.com.email.dto.EmailDTO;
import br.com.email.properties.PropertiesProvider;
import br.com.email.service.Email;

public class EmailImpl implements Email {
	
	private final String CHARSET = "charset";
	private MultiPartEmail email;
	private HtmlEmail htmlEmail;
	private static Properties props;
	
	public EmailImpl() {
		email = new MultiPartEmail();
		htmlEmail = new HtmlEmail();
	}

	public void enviarEmail(EmailDTO templateEmail) {
		try {
			props = PropertiesProvider.getProperties();
		
			email.setHostName(templateEmail.getSmtp());
			//email.setSmtpPort(templateEmail.getPortaSmtp());
            email.setSSL(true);
			email.setFrom(templateEmail.getEmailRemetente(), templateEmail.getNomeRemetente());
			email.setSubject(templateEmail.getAssunto());
			email.setMsg(templateEmail.getMensagem());
			email.setCharset(props.getProperty(CHARSET));
			email.setAuthentication(templateEmail.getConta(), templateEmail.getSenha());
			email.setTo(templateEmail.getEmailsDestinatarios());
			if (templateEmail.getEmailsDestinatariosEmCopia() != null
					&& !templateEmail.getEmailsDestinatariosEmCopia().isEmpty()) {
				email.setCc(templateEmail.getEmailsDestinatariosEmCopia());
			}
			if (templateEmail.getEmailsDestinatariosEmCopiaOculta() != null
					&& !templateEmail.getEmailsDestinatariosEmCopiaOculta().isEmpty()) {
				email.setBcc(templateEmail.getEmailsDestinatariosEmCopiaOculta());
			}
			email.send();
		} catch (EmailException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}

	public void enviarEmailHtml(EmailDTO templateEmail) {
		try {
			props = PropertiesProvider.getProperties();
		
			htmlEmail.setHostName(templateEmail.getSmtp());
			//email.setSmtpPort(templateEmail.getPortaSmtp());
			htmlEmail.setSSL(true);
			htmlEmail.setFrom(templateEmail.getEmailRemetente(), templateEmail.getNomeRemetente());
			htmlEmail.setSubject(templateEmail.getAssunto());
			htmlEmail.setMsg(templateEmail.getMensagem());
			htmlEmail.setCharset(props.getProperty(CHARSET));
			htmlEmail.setAuthentication(templateEmail.getConta(), templateEmail.getSenha());
			htmlEmail.setTo(templateEmail.getEmailsDestinatarios());
			if (templateEmail.getEmailsDestinatariosEmCopia() != null
					&& !templateEmail.getEmailsDestinatariosEmCopia().isEmpty()) {
				htmlEmail.setCc(templateEmail.getEmailsDestinatariosEmCopia());
			}
			if (templateEmail.getEmailsDestinatariosEmCopiaOculta() != null
					&& !templateEmail.getEmailsDestinatariosEmCopiaOculta().isEmpty()) {
				htmlEmail.setBcc(templateEmail.getEmailsDestinatariosEmCopiaOculta());
			}
			htmlEmail.send();
		} catch (EmailException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void enviarListaEmails(List<EmailDTO> emails) {
		if (emails != null) {
			for (EmailDTO templateEmail : emails) {
				enviarEmail(templateEmail);
			}
		}
	}

	public void enviarListaEmailsHtml(List<EmailDTO> emails) {
		if (emails != null) {
			for (EmailDTO templateEmail : emails) {
				enviarEmailHtml(templateEmail);
			}
		}
	}
}