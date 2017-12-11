package tPCertificatifApp.service;



import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class MailService {

	public void sendMail(String to, String subject, String message,String pathName) throws Exception{
		try {
			Properties props = ReadMailProperties.getMailProperties(pathName); 
			Authenticator auth = new SMTPAuthenticator(props.getProperty("mail.user"), props.getProperty("mail.password"));
			Session session = Session.getInstance(props, auth);
			
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);
			Transport.send(mimeMessage);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class SMTPAuthenticator extends Authenticator {

		private PasswordAuthentication authentication;

		public SMTPAuthenticator(String login, String password) {
			authentication = new PasswordAuthentication(login, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}

}
