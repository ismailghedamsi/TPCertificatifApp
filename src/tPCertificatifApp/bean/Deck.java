package tPCertificatifApp.bean;



import java.util.ArrayList;
import java.util.List;
/**
 * Classe represantant un Deck qui est une collection de pantcarte (Flashcard)
 * @author small44
 *
 */
public class Deck {
	private static int counter;
	private int idDeck;
	private String deckName;
	
	public Deck(AbstractUser deckCreator) {
		this.deckCreator = deckCreator;
		flashCardList = new ArrayList<FlashCard>();
		idDeck = counter;
		counter++;
	}
	
	public Deck(String deckName) {
		this.deckName = deckName;
		flashCardList = new ArrayList<FlashCard>();
		idDeck = counter;
		counter++;
	}
	
	
	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}

	private List<FlashCard> flashCardList;
	private AbstractUser deckCreator;


	public AbstractUser getDeckCreator() {
		return deckCreator;
	}

	public void setDeckCreator(AbstractUser deckCreator) {
		this.deckCreator = deckCreator;
	}

	public List<FlashCard> getFlashCardList() {
		return flashCardList;
	}

	public void setFlashCardList(List<FlashCard> flashCardList) {
		this.flashCardList = flashCardList;
	}

	public int getIdDeck() {
		return idDeck;
	}
	
	
	
	
	
}
