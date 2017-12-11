package tPCertificatifApp.service;



import java.util.Collections;
import java.util.List;

import tPCertificatifApp.bean.*;
import tPCertificatifApp.util.DAOUtil;



public class UserDao implements DAOUtil<AbstractUser> {
	private final int NBTOPUSER = 10;
	
	/**
	 * Recherche d'une utilisateur avec son idantifiant
	 */
	@Override
	public AbstractUser getElementsById(List<AbstractUser> list, int id) {
		for(AbstractUser abstractUser : list) {
			if(abstractUser instanceof NormalUser) {
				if(((NormalUser) abstractUser).getId() == id) {
					return abstractUser;
				}
			}else {
				if(((Admin) abstractUser).getId() == id) {
					return abstractUser;
			}
		
		}
		}
		return null;
	}
	
	public AbstractUser  getElementByEmail(List<AbstractUser> list, String email) {
		for (AbstractUser currentUser : list) {
			if(currentUser.getCredentials().getLogin().equals(email)) {
				return currentUser;
			}
		}
		return null;
	}



	@Override
	/**
	 * Ajout d'une utlisateur
	 */
	public boolean add(List<AbstractUser> list, AbstractUser element) {
		// TODO Auto-generated method stub
		return list.add(element);
	}


	/**
	 * Supprimer un utlisateur par son id
	 */
	@Override
	public boolean deleteById(List<AbstractUser> list, int id) {
		for(AbstractUser abstractUser : list) {
			if(abstractUser instanceof NormalUser) {
				if((((NormalUser) abstractUser).getId()) == id) {
					return list.remove(abstractUser);
				}
			}else {
				if((((Admin) abstractUser).getId()) == id) {
					return list.remove(abstractUser);
				}
			}
			
		}
		return false;
	}


	/**
	 * Recuperer un utilisateur aleatoire
	 * @return l'utilisateur
	 */
	@Override
	public AbstractUser getRandomElement(List<AbstractUser> list) {
		int randomIndex = (int) (Math.random()*list.size());
		return list.get(randomIndex);
	}
	
	public List<AbstractUser> getTopUser(List<AbstractUser> listeUser) {
		Collections.sort(listeUser);
		if(listeUser.size() < NBTOPUSER) {
			return listeUser;
		}
		return listeUser.subList(0, 9);
	}
	


}
