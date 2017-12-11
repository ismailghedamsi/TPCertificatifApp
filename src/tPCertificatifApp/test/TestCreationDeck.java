package tPCertificatifApp.test;



import java.io.File;

import com.rmtheis.yandtran.language.Language;

import tPCertificatifApp.bean.*;
import tPCertificatifApp.service.*;



public class TestCreationDeck {
	public static void main(String[] args) {
		DeckDao deckDao = new DeckDao();
		DeckPersistanceService deckps = new DeckPersistanceService();
		Deck deck1 = new Deck(new AbstractUser(null,null,0));
		Deck deck2 = new Deck(new AbstractUser(null, null, 0));
		//Creation des flashcard
		FlashCard fc1 = new FlashCard("hola", Language.SPANISH, Language.ENGLISH);
		FlashCard fc2 = new FlashCard("leer", Language.SPANISH, Language.ENGLISH);
		deckDao.add(deck1.getFlashCardList(), fc1);
		deckDao.add(deck1.getFlashCardList(), fc2);
		// Decks are stored decks folder in user home folder
		if(!new File(System.getProperty("user.home")+File.separator+"decks"+File.separator).exists()){
			new File(System.getProperty("user.home")+File.separator+"decks"+File.separator).mkdirs();
		}
		deckps.saveElementToXML(System.getProperty("user.home")+File.separator+"decks"+File.separator+deck2.getIdDeck()+".xml",deck2);
		
	}
}
