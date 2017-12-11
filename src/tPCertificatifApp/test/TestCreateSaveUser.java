package tPCertificatifApp.test;



import java.io.File;

import tPCertificatifApp.bean.*;
import tPCertificatifApp.service.*;




public class TestCreateSaveUser {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		UserPersistanceService userPersistanceService = new UserPersistanceService();
		RegistredUsers registredUser = new RegistredUsers();
		AbstractUser user1 = new NormalUser("ismail", "ghedamsi", 24);
		System.out.println("credential"+user1.getCredentials().getLogin());
		AbstractUser user2 = new NormalUser("ahmed", "ghedamsi", 18);
		AbstractUser user3 = new NormalUser("nasser", "ghedamsi", 26);
		userDao.add(registredUser.getListUsers(), user1);
		userDao.add(registredUser.getListUsers(), user2);
		userDao.add(registredUser.getListUsers(), user3);
		if(!new File(System.getProperty("user.home")+File.separator+"users"+File.separator).exists()){
			new File(System.getProperty("user.home")+File.separator+"users"+File.separator).mkdirs();
		}
		userPersistanceService.saveElementToXML(System.getProperty("user.home")+File.separator+"users"+File.separator+"users"+".xml",registredUser.getListUsers());
		
	}
}
