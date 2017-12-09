package TPCertificatifApp.service;



import java.util.Collections;
import java.util.List;

import TPCertificatifApp.bean.*;
import TPCertificatifApp.util.DAOUtil;



public class UserDao implements DAOUtil<AbstractUser> {
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
	
	public void showLeaderBord(List<AbstractUser> listeUser) {
		Collections.sort(listeUser);
		for (AbstractUser abstractUser : listeUser) {
			System.out.println(abstractUser.getFirstName() + " : "+abstractUser.getPoints());
		}
	}
	


}
