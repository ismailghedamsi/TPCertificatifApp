package TPCertificatifApp.bean;


/**
 * Utilisateur admin
 * @author small44
 *
 */
public class Admin extends AbstractUser {
	private int id;
	private static int counter;
	 private Credentials credentials;
	 private String login;
	   private String password;
	   
	   
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Admin(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
		credentials = new Credentials(login, password);
		id = counter;
		counter++;
	}
	
	public int getId() {
		return id;
	}

}
