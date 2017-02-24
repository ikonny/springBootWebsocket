package cn.hkfdt.xiaot.web.xiaot.service;


import cn.hkfdt.xiaot.mybatis.model.ltschina.ForceAnalysis;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;

import java.util.List;
import java.util.Map;

public interface XiaoTService {
	/**
	 * @param fdtId
	 * @param market  0：期货  1:股票  2：外汇
	 * @return
	 * author:xumin 
	 * 2016-12-15 下午4:20:10
	 */
	ForceAnalysis getXiaotForceAnalysis(String fdtId, int market);
	/**
	 * 需要拉取分页
	 * @param mapPara
	 * @param mapTar 
	 * @return
	 * author:xumin 
	 * 2016-12-22 下午6:37:41
	 */
	int getXiaotRecord(Map<String, Object> mapPara, Map<String, Object> mapTar);

	/**
	 * 获取某个市场的前50名
	 * @param market 0：期货战绩  1:股票  2：外汇',
	 * @param isflush 
	 * @return
	 * author:xumin 
	 * 2016-12-19 下午2:43:26
	 */
	List<Map<String, Object>> getXiaotMasterList(int market, boolean isflush);
	/**
	 * 获取某个市场的训练数据。一次性返回很多行情数据
	 * 数据是预先准备好的
	 * @param fdtId 
	 * @param market 0：期货  1:股票  2：外汇
	 * @param type all：全部  history:历史  today：今日
	 * @param mapTar
	 * @return
	 * author:xumin 
	 * 2016-12-16 上午10:07:26
	 */
	TQuestions xiaotTraining(String fdtId, int market, Map<String, Object> mapTar, String type);
	/**
	 * 请求远程服务，对本次训练结果打分
	 * @param fdtId
	 * @param body json数据，参考协议
	 * @param mapTar
	 * @return
	 * author:xumin 
	 * 2016-12-19 下午3:18:05
	 */
	int xiaotDoScore(String fdtId, String body, Map<String, Object> mapTar);
	/**
	 * 
	 * @param market
	 * @param mapTar
	 * @return
	 * author:xumin 
	 * 2016-12-19 下午5:59:40
	 */
	int initTQuestions(int market, Map<String, Object> mapTar);

}
