package TPCertificatifApp.service;

import com.rmtheis.yandtran.language.Language;
import com.rmtheis.yandtran.translate.Translate;

import TPCertificatifApp.bean.*;
import TPCertificatifApp.util.DAOUtil;


/**
 * Classe service pour generer la session
 * @author small44
 *
 */
public class ServiceOperation {
	/**
	 * 
	 * @param word
	 * @param wordLanguage
	 * @param translateWord
	 * @return la traduction du mot a la langue souhaitee
	 * @throws Exception
	 */
	public static String translateWord(String word,Language wordLanguage,Language translateWord) throws Exception {
		// Cle pour utiliser l'api
	  Translate.setKey("trnsl.1.1.20171105T033144Z.9d69b029915c4ebb.74471b753cf5248958e3569a35e79f2d0d70ff96");
	  	
        return Translate.execute(word, wordLanguage, translateWord); // recupere la trauction
	}
	
	/**
	 * 
	 * @param currentFlashBack
	 * @param answer
	 * @return Si l'tulisateur a eu une bonne reponse ou non
	 */
	public static boolean verifieAnswer(FlashCard currentFlashBack ,String answer) {
		return currentFlashBack.getTranslation().equalsIgnoreCase(answer);
	}
	
	/**
	 * Verifie that the user get a badge for having a score greater than the value of constant POINTBADGEVALUE
	 * @param user
	 * @return
	 */
	public static boolean pointBadge(AbstractUser user) {
		return user.getPoints()>DAOUtil.POINTBADGEVALUE;
	}
	
	public static int sessionDuration(LearningSession learningSession) {
		return 0;
	}
	
	public void SuperMemoAlgorithm() {
		
	}
	
	/*public boolean authentificationVerification(String email,String password) {
		UserPersistanceService userPersistanceService = new UserPersistanceService();
		RegistredUsers registredUsers = userPersistanceService.loadElement("");
		return false;
	}*/
	
	/*
	 * Calculate time spended in the learning session
	 */
	public void calculateSessionTime() throws Exception {
		
		int seconds = 0;
		int minutes = 0;
		int hours = 0;
		String sessionTime = "";

		while(true) {
			Thread.sleep(1000);
			seconds++;
			if(seconds == 60 ) {
				minutes++; 
			    seconds = 0;
			}else if(minutes == 60) {
				hours++;
				minutes = 0;
			}
		}
		
	}
}
