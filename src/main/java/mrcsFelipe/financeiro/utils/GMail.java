package mrcsFelipe.financeiro.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class GMail {

	public static final String SERVIDOR_SMTP = "smtp.gmail.com";
	public static final String PORTA_SERVIDOR_SMTP = "465";
	private static final String CONTA_GMAIL = "mfelipesp@gmail.com";
	private static final String SENHA_GMAIL = "1992lipe";

	private String de;
	private String para;
	private String assunto;
	private String mensagem;
 
	public GMail(String de, String para, String assunto, String mensagem) {
		this.de = de;
		this.para = para;
		this.assunto = assunto;
		this.mensagem = mensagem;
		try {
			this.enviarEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviarEmail() throws Exception{
//		FacesContext context = FacesContext.getCurrentInstance();
		AutenticaUsuario autenticaUsuario = new AutenticaUsuario(GMail.CONTA_GMAIL, GMail.SENHA_GMAIL);
		Session session = Session.getDefaultInstance(this.configuracaoEmail(),
				autenticaUsuario);
		// Habilita o LOG das ações executadas durante o envio do email
		session.setDebug(true);

		try {
			Transport envio = null;
			MimeMessage email = new MimeMessage(session);
			email.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para));
			email.setFrom(new InternetAddress(this.de));
			email.setSubject(this.assunto);
			email.setContent(this.mensagem, "text/plain");
			email.setSentDate(new Date());
			envio = session.getTransport("smtp");
			envio.connect(GMail.SERVIDOR_SMTP, GMail.CONTA_GMAIL,GMail.SENHA_GMAIL);
			email.saveChanges();
			envio.sendMessage(email, email.getAllRecipients());
			envio.close();

			//context.addMessage(null, new FacesMessage("E-mail enviado com sucesso"));

		} catch (AddressException e) {
			
			return;
		} catch (MessagingException e) {
			
			return;
		}
	}

	public Properties configuracaoEmail() {
		Properties config = new Properties();

		// Configuração adicional para servidor proxy.
		// Descomentar somente se utliza servidor com proxy.
		/*
		 * props.setProperty("proxySet", "true");
		 * props.setProperty("socksProxyHost","127.0.0.1"); //IP do Servidor
		 * Proxy props.setProperty("socksProxyPort","8080"); //Porta do servidor
		 * Proxy
		 */
		config.put("mail.transport.protocol", "smtp"); // define protocolo de
														// envio como SMTP
		config.put("mail.smtp.starttls.enable", "true");
		config.put("mail.smtp.host", SERVIDOR_SMTP); // servidor SMTP do GMAIL
		config.put("mail.smtp.auth", "true"); // ativa autenticacao
		config.put("mail.smtp.user", GMail.CONTA_GMAIL); // conta que esta
																// enviando o
																// email
		config.put("mail.debug", "true");
		config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP); // porta
		config.put("mail.smtp.socketFactory.port", PORTA_SERVIDOR_SMTP); // mesma
																			// porta
																			// para
																			// o
																			// socket
		config.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		config.put("mail.smtp.socketFactory.fallback", "false");
		return config;
	}
	
}
