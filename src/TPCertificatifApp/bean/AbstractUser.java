package TPCertificatifApp.bean;



import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author small44
 * Classe abstraite representent les utilisateurs noremaux et admins 
 */
public class AbstractUser implements Comparable<AbstractUser>{
	private String firstName;
	private String lastName;
	private int age;
	private int points;
	private List<Badge> badgeList;
	private Credentials credentials;
	private String login;
	private String password;
	public AbstractUser(String firstName, String lastName, int age) {
		credentials = new Credentials(login, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.points = 0;
		setBadgeList(new ArrayList<Badge>());
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}
	
	


	public Credentials getCredentials() {
		return credentials;
	}


	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}


	@Override
	public int compareTo(AbstractUser o) {
		// TODO Auto-generated method stub
		return new Integer(this.getPoints()).compareTo(new Integer(o.getPoints()));
	}


	public List<Badge> getBadgeList() {
		return badgeList;
	}


	public void setBadgeList(List<Badge> badgeList) {
		this.badgeList = badgeList;
	}
	
	
}
