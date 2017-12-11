package tPCertificatifApp.bean;



import java.util.ArrayList;
import java.util.List;

public class RegistredUsers {
	private List<AbstractUser> listUsers;
	private List<String> listMails;
	
	
	
	public List<String> getListMails() {
		return listMails;
	}

	public void setListMails(List<String> listMails) {
		this.listMails = listMails;
	}

	public RegistredUsers() {
		listUsers = new ArrayList<AbstractUser>();
		listMails = new ArrayList<String>();
	}

	public List<AbstractUser> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<AbstractUser> listUsers) {
		this.listUsers = listUsers;
	}
	
	
}
