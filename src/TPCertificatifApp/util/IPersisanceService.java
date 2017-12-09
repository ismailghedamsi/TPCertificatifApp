package TPCertificatifApp.util;



import java.io.File;
import java.io.FileNotFoundException;

 
/**
 * Les methode epour la persistance des donnees
 * @author small44
 *
 * @param <T>
 */
public interface IPersisanceService<T> {
	public final String USER_SAVE_LOCATION = System.getProperty("user.home")+File.separator+"users"+File.separator;
	public boolean saveElementToXML(String pathName,T elem);
	public T loadElement(String pathName) throws FileNotFoundException;
}
//todo
