package tPCertificatifApp.service;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class ReadMailProperties {
	
	public static Properties getMailProperties(String pathName){
		
		Properties props = new Properties();
		try {
			
			props.load(new FileInputStream(pathName));
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.user", props.getProperty("login"));
			props.setProperty("mail.password", props.getProperty("password"));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return props;
		
	}
	
	public static void createPropertieFile(String login,String password) throws Exception {
		Properties usermailproperties = new Properties();
		FileOutputStream out = new FileOutputStream("/home/small44/user1mail.properties");
		usermailproperties.setProperty("login", login);
		usermailproperties.setProperty("password",password);
		usermailproperties.setProperty("mail.smtp.auth", "true");
		usermailproperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		usermailproperties.setProperty("mail.smtp.host", "smtp.gmail.com");
		usermailproperties.setProperty("mail.smtp.socketFactory.port", "465");
		usermailproperties.setProperty("mail.smtp.port", "465");
		usermailproperties.store(out, null);
		out.close();
	}
	

}
