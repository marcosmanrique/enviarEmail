package br.com.email.service;

import br.com.email.template.TemplateEmail;

public interface Email {

	public abstract void enviarEmail(TemplateEmail email);

	public abstract void enviarEmailHtml(TemplateEmail email);

}
