package br.com.email.template;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;

public class TemplateEmail {

	private String smtp;

	private Integer portaSmtp;

	private String conta;

	private String senha;

	private String assunto;

	private String mensagem;

	private String emailRemetente;

	private String nomeRemetente;

	private List<InternetAddress> emailsDestinatarios;

	private List<InternetAddress> emailsDestinatariosEmCopia;

	private List<InternetAddress> emailsDestinatariosEmCopiaOculta;

	public TemplateEmail() {
		emailsDestinatarios = new ArrayList<InternetAddress>();
		emailsDestinatariosEmCopia = new ArrayList<InternetAddress>();
		emailsDestinatariosEmCopiaOculta = new ArrayList<InternetAddress>();
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public Integer getPortaSmtp() {
		return portaSmtp;
	}

	public void setPortaSmtp(Integer portaSmtp) {
		this.portaSmtp = portaSmtp;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getEmailRemetente() {
		return emailRemetente;
	}

	public void setEmailRemetente(String emailRemetente) {
		this.emailRemetente = emailRemetente;
	}

	public String getNomeRemetente() {
		return nomeRemetente;
	}

	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}

	public List<InternetAddress> getEmailsDestinatarios() {
		return emailsDestinatarios;
	}

	public void addEmailDestinatario(InternetAddress email) {
		emailsDestinatarios.add(email);
	}

	public List<InternetAddress> getEmailsDestinatariosEmCopia() {
		return emailsDestinatariosEmCopia;
	}

	public void addEmailDestinatarioEmCopia(InternetAddress email) {
		emailsDestinatariosEmCopia.add(email);
	}

	public List<InternetAddress> getEmailsDestinatariosEmCopiaOculta() {
		return emailsDestinatariosEmCopiaOculta;
	}

	public void addOEmailDestinatarioEmCopiaOculta(InternetAddress email) {
		emailsDestinatariosEmCopiaOculta.add(email);
	}
}
