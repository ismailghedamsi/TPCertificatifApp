package TPCertificatifApp.bean;

/**
 * Utilisateur normal 
 * @author small44
 *
 */
public class NormalUser extends AbstractUser {
	private int id;
	private static int counter;
    //private Credentials credentials;
    private String login;
    private String password;
	public NormalUser(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
		//credentials = new Credentials(login, password);
		id = counter;
		counter++;
		
	}
	public int getId() {
		return id;
	}
	/*public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}*/
	
	
	
	

}
