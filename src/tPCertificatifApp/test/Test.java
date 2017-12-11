package tPCertificatifApp.test;




import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import com.rmtheis.yandtran.language.Language;
import com.sun.mail.iap.Response;

import tPCertificatifApp.service.*;
import tPCertificatifApp.util.DAOUtil;
import tPCertificatifApp.bean.*;



public class Test {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DeckPersistanceService deckps = new DeckPersistanceService();
		MailService mailService = new MailService();
		UserPersistanceService ups = new UserPersistanceService();
		UserDao userDao = new UserDao();
		RegistredUsers ru = new RegistredUsers();
		 try {
				//mailService.sendMail("ismailghedamsi@gmail.com", "Confirmation mail", "your code is "+UUID.randomUUID(),"/home/small44/user1mail.properties");
				//ReadMailProperties.createPropertieFile("ismailghedamsi@gmail.com","idarnastsrias1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		Scanner sc = new Scanner(System.in);
		String response="";
		DeckDao deckdao = new DeckDao();
		ServiceOperation operation = new ServiceOperation();
		AbstractUser user1 = new NormalUser("ismail","ghedamsi",24);
		AbstractUser user2 = new NormalUser("ahmed", "Ghedamsi", 18);
		AbstractUser user3 = new NormalUser("leila","ghedamsi",24);
		AbstractUser user4 = new NormalUser("nasser", "Ghedamsi", 18);
	
	
		Deck deck = new Deck(user1);
		deck.getFlashCardList().add(new FlashCard("hello", Language.ENGLISH, Language.SPANISH));
		//Load Users
		List<AbstractUser> userList = ups.loadElement(System.getProperty("user.home")+File.separator+"users.xml");
		LearningSession session = new LearningSession(userList.get(1), deck);
		FlashCard fs = deckdao.getRandomElement(deck.getFlashCardList());
		deck.getFlashCardList().add(fs);
		//Add user to the system
		
		deckps.saveElementToXML(System.getProperty("user.home")+File.separator+"deck.xml", deck);
		userDao.add(ru.getListUsers(), user1);
		//userDao.add(ru.getListUsers(), user2);
		//userDao.add(ru.getListUsers(), user3);
		//userDao.add(ru.getListUsers(), user4);
		//ups.saveElementToXML(System.getProperty("user.home")+File.separator+"users.xml", ru.getListUsers());
		while(!response.equals("q")) {
			
			WorkingJobs job = new WorkingJobs(session.getUser(),session);
			new Thread(job).start();
			System.out.println("Enter the translation of "+fs.getWord());
			response = sc.nextLine();
			if(ServiceOperation.verifieAnswer(fs, response)) {
				
				session.getUser().setPoints(session.getUser().getPoints()+DAOUtil.GOODRESPONSEPOINT);
				System.out.println("Reponse correcte");
			}
			
		}
		ups.saveElementToXML(System.getProperty("user.home")+File.separator+"users.xml", ru.getListUsers());
		
	}
}
