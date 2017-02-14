package cn.hkfdt.xiaot.websocket.task;

import cn.hkfdt.xiaot.mybatis.mapper.ltschina.AuthMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.hkfdt.xiaot.websocket.service.impl.MatchServiceHelper;

@Service
public class TaskMatch {

	@Autowired
	AuthMapper authMapper;//不加@mapper是不能运行的
	//=====================================
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
//	@Scheduled(cron="0/10 * *  * * ? ")
	public void everyDayNight(){
		Auth item = authMapper.selectByPrimaryKey("123456123456","nsfdbs@qq.kk");
		System.err.println(item);
	}
	@Scheduled(cron="0 0/2 *  * * ? ")
	public void mapMatchInfoHS(){
		MatchServiceHelper.recoverMatchInfo();
//		System.err.println("+++++");
	}

}
