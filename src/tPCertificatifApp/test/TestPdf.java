package tPCertificatifApp.test;





import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import tPCertificatifApp.bean.*;
import tPCertificatifApp.service.*;
public class TestPdf {
	public static void main(String[] args) throws Exception {
		RegistredUsers ru = new RegistredUsers();
		UserPersistanceService ups = new UserPersistanceService();
		List<AbstractUser> userList = ups.loadElement(System.getProperty("user.home")+File.separator+"users"+File.separator+"users.xml");
		ru.setListUsers(userList);
		ServicePdf servicePdf = new ServicePdf(ru);
		servicePdf.generateCommandePDF("/home/small44/Utilisateur2.pdf");
	}
}
