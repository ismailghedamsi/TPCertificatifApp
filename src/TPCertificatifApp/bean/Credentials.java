package TPCertificatifApp.bean;


import java.util.*;
public class Credentials {
	private String login;
	private String password;
	private String id;
	private Map<String,String> secretQuestions;
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getSecretQuestions() {
		return secretQuestions;
	}

	public void setSecretQuestions(Map<String, String> secretQuestions) {
		this.secretQuestions = secretQuestions;
	}

	//Interdit constructeur vide pour credentials
	public Credentials (String login,String password) {
		this.login = login;
		this.password = password;
	}
	
	public Credentials (String id,String login,String password) {
		this.id =id;
		this.login = login;
		this.password = password;
	}
}
