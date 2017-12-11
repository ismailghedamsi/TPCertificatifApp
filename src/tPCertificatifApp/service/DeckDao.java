package tPCertificatifApp.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import tPCertificatifApp.bean.*;
import tPCertificatifApp.util.*;

public class DeckDao implements DAOUtil<FlashCard> {

	/**
	 * Recherche d'une pancarte avec son idantifiant
	 */
	@Override
	public FlashCard getElementsById(List<FlashCard> list, int id) {
		for (FlashCard flashcard : list) {
			if (flashcard.getIdFlashCard() == id) {
				return flashcard;
			}
		}
		return null;

	}

	/**
	 * Ajout d'une pancarte dans un Deck
	 */
	@Override
	public boolean add(List<FlashCard> list, FlashCard element) {
		return list.add(element);
	}

	/**
	 * Supprimer une pancard du deck par son id
	 */
	@Override
	public boolean deleteById(List<FlashCard> list, int id) {
		for (FlashCard flashcard : list) {
			if (flashcard.getIdFlashCard() == id) {
				return list.remove(flashcard);
			}
		}
		return false;
	}

	/**
	 * Recuperer une pancarte aleatoire
	 * 
	 * @return la pancarte souhaite
	 */
	@Override
	public FlashCard getRandomElement(List<FlashCard> list) {
		int randomIndex = (int) (Math.random() * list.size());
		return list.get(randomIndex);
	}

	public Deck getDeckById(int id) throws Exception {
		DeckPersistanceService deckPersistanceService = new DeckPersistanceService();
		File sourcePathRef = new File(IPersisanceService.DECK_SAVE_LOCATION);
		String[] extensions2 = new String[] { "xml" };
		List<File> files = (List<File>) FileUtils.listFiles(sourcePathRef, extensions2, false);
		for (File currentFile : files) {
			Deck deck = deckPersistanceService.loadElement(currentFile.getCanonicalPath());
			if(deck.getIdDeck() == id) {
				return deck;
			}
		}

		return null;
	}
}
