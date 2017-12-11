package tPCertificatifApp.service;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import tPCertificatifApp.bean.AbstractUser;
import tPCertificatifApp.util.IPersisanceService;



public class UserPersistanceService implements IPersisanceService<List<AbstractUser>> {
	
	
	
	public UserPersistanceService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * recuperer les utilisateurs dans un fichier xml
	 */
	@Override
	public List<AbstractUser> loadElement(String pathName) throws FileNotFoundException {
		XStream stream = new XStream(new DomDriver());
		stream.processAnnotations(UserPersistanceService.class);
		stream.alias("List",List.class);
		return   (List<AbstractUser>) stream.fromXML(new FileInputStream(pathName));
		
	}

	/**
	 * Sauvegarder les utilisateurs dans un fichier xml
	 */
	@Override
	public boolean saveElementToXML(String pathName, List<AbstractUser> elem) {
		try {

			XStream stream = new XStream(new DomDriver());
			stream.processAnnotations(UserPersistanceService.class);
			stream.alias("List",List.class);

			stream.toXML(elem, new FileOutputStream(pathName));

			return new File(pathName).exists();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

}
