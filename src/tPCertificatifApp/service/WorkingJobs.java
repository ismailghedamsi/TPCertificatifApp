package tPCertificatifApp.service;

import tPCertificatifApp.bean.AbstractUser;
import tPCertificatifApp.bean.Badge;
import tPCertificatifApp.bean.LearningSession;

public class WorkingJobs implements Runnable {
	AbstractUser user;
	LearningSession learningSession;
	 public WorkingJobs(AbstractUser user,LearningSession learningSession) {
		this.user = user;
		this.learningSession = learningSession;
	}
	@Override
	public void run() {
		ServiceOperation.pointBadge(user);
	if(ServiceOperation.pointBadge(user)) {
			user.getBadgeList().add(new Badge("1000 points", ""));
			System.out.println("vous avez obtenu badge");
		}
	
		System.out.println(ServiceOperation.sessionDuration(learningSession));
	}

}
