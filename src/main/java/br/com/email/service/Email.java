package br.com.email.service;

import java.util.List;

import br.com.email.dto.EmailDTO;

public interface Email {

	public abstract void enviarEmail(EmailDTO email);

	public abstract void enviarEmailHtml(EmailDTO email);

	public abstract void enviarListaEmails(List<EmailDTO> email);

	public abstract void enviarListaEmailsHtml(List<EmailDTO> email);

}
