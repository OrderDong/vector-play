package cn.com.vector.play.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PlayContractTask {
	
	@Scheduled(cron = "0 */1 * * * ? ")
	public void executeOverWar(){
		System.out.println("executeOverWar......");
	}
	
	@Scheduled(cron = "*/30 * * * * ? ")
	public void executeTransferCard(){
		System.out.println("executeTransferCard......");
	}
	
	@Scheduled(cron = "*/30 * * * * ? ")
	public void executeTransferDDC(){
		System.out.println("executeTransferDDC......");
	}
}
