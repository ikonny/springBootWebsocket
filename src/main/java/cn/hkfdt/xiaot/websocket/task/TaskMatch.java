package cn.hkfdt.xiaot.websocket.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;

@Service
public class TaskMatch {

	public TaskMatch(){
//		System.err.println("TaskTest初始化！！！");
	}
	/**
	 * @param args
	 * author:xumin 
	 * 2016-6-28 下午3:23:34
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
////	@Scheduled(cron="0/30 * *  * * ? ")
//	public void everyDayNight(){
//		if(MainTestController.tradeService==null)
//			return;
//		String day = MainTestController.tradeService.getTradingDay();
//		String now = TimeUtil.getToday();
//		String time = TimeUtil.getTodayTime();
//		if(!day.equals(now)){
//			System.err.println("=================&&&&&&&&&找到了！："+"now:"+now+"-"+time+"   TradingDay:"+day);
//		}
//		System.err.println("now:"+now+"-"+time+"   TradingDay:"+day);
//	}
	@Scheduled(cron="0 0/2 *  * * ? ")
	public void mapMatchInfoHS(){
		MatchServiceHelper.recoverMatchInfo();
		System.err.println("+++++");
	}

}
