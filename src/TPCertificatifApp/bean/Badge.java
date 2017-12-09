package TPCertificatifApp.bean;



public class Badge {
	private String badgeName;
	private String imagePath;
	
	
	
	public Badge(String badgeName, String imagePath) {
		super();
		this.badgeName = badgeName;
		this.imagePath = imagePath;
	}
	public String getBadgeName() {
		return badgeName;
	}
	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
