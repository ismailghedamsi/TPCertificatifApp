package tPCertificatifApp.bean;



import java.util.Date;
import java.util.Timer;

/**
 * Classe represantant une session d'apprentissage
 * @author small44
 *
 */
public class LearningSession {
	private AbstractUser user;
	private Deck deck;
	private long sessionBeginning;
	
	
	public long getSessionBeginning() {
		return sessionBeginning;
	}
	public void setSessionBeginning(long sessionBeginning) {
		this.sessionBeginning = sessionBeginning;
	}
	public LearningSession(AbstractUser user, Deck deck) {
		super();
		this.user = user;
		this.deck = deck;
	    sessionBeginning = new Date().getTime();
	}
	public AbstractUser getUser() {
		return user;
	}
	public void setUser(AbstractUser user) {
		this.user = user;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
	
}
