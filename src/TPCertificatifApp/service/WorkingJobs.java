package TPCertificatifApp.service;

import TPCertificatifApp.bean.AbstractUser;
import TPCertificatifApp.bean.Badge;

public class WorkingJobs implements Runnable {
	AbstractUser user;
	 public WorkingJobs(AbstractUser user) {
		this.user = user;
	}
	@Override
	public void run() {
		ServiceOperation.pointBadge(user);
	if(ServiceOperation.pointBadge(user)) {
			user.getBadgeList().add(new Badge("1000 points", ""));
			System.out.println("vous avez obtenu badge");
		}
	}

}
