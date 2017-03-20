package cn.hkfdt.xiaot.web.xiaot.service.md;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNew;
import com.alibaba.fastjson.JSON;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理行情数据的获取
 * author:xumin 
 * 2016-12-20 下午4:20:11
 */
@Service
public class XiaoTMDDBHelper {

	static final String mdDbKey = "xiaoT_mdDbKey";
//	@Autowired 好像不起作用
	public static JdbcTemplate jdbcTemplate;
	//=============================================
	/**
	 * @param args
	 * author:xumin 
	 * 2016-12-20 下午4:19:54
	 */
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>(3);
//		map.put("url", "jdbc:mysql://192.168.4.152:3306/TA_DS_TEST");//数据太少，不行，直接连接测试库
		map.put("url", "jdbc:mysql://192.168.4.71:3306/INFO_SIM");
		map.put("user", "tqt001");
		map.put("pass", "tqt002");//tqt002
		
		String str = JSON.toJSONString(map);//JsonUtil.ObToJson(map);
		System.err.println(str);
	}
	/**
	 * 获取数据库中配置信息.
	 * @return  valuejson
	 * author:xumin 
	 * 2016-12-20 下午7:17:33
	 */
	public static Map<String, Object> getPerSistentInfo(String code) {
		String sql = "SELECT valuejson FROM ctp_persistent WHERE CODE = '" +code +"'";
		JdbcTemplate jt = getJdbcTemplate();
		return jt.queryForMap(sql);
	}
	private static JdbcTemplate getJdbcTemplate() {
		if(jdbcTemplate==null){
			WebApplicationContext wc = ContextLoaderListener.getCurrentWebApplicationContext();
			jdbcTemplate = (JdbcTemplate) wc.getBean("jdbcTemplate");
		}
		return jdbcTemplate;
	}
	/**
	 * 获取当前交易日一日的分钟线
	 * @param item
	 * @param market 现在就是期货
	 * @return
	 * author:xumin 
	 * 2016-12-20 下午4:42:44
	 */
	public static List<Map<String, Object>> getHistoryMinData(TQuestionsNew item, int market) {
		String exchangeCode = item.getExchangeCode();//DCE等
		String shortSymbol = item.getShortSymbol();//A等 大豆缩写
		String tradeDay = item.getTradeDay();//题目交易当日，北京时间
		String tableName = exchangeCode+"_1";//DCE_1
		String SYMBOL = shortSymbol+"."+exchangeCode;//主力合约 A.DCE
		//SELECT * FROM DCE_1 WHERE TRADEDATE = '2016-05-26' AND SYMBOL = 'L.DCE'  ORDER BY DATATIME
		String sql = "SELECT * FROM " +
				tableName +
				" WHERE TRADEDATE = '" +
				tradeDay +
				"' AND SYMBOL = '" +
				SYMBOL +
				"'  ORDER BY DATATIME LIMIT 200";
		return XiaoTJdbcDriver.queryForList(sql);
	}
	/**
	 * 从指定日起，指定交易所品种的主力品种，获取之前79天，包含指定日，日行情.
	 * 日期最新在最前
	 * @param item
	 * @param market
	 * @return
	 * author:xumin 
	 * 2016-12-20 下午8:12:19
	 */
	public static List<Map<String, Object>> getHistoryDayData(TQuestionsNew item,
			int market) {
		String exchangeCode = item.getExchangeCode();//DCE等
		String shortSymbol = item.getShortSymbol();//A等 大豆缩写
		String tradeDay = item.getTradeDay();//题目交易当日，北京时间
		String tableName = exchangeCode+"_D";//DCE_D
		String SYMBOL = shortSymbol+"."+exchangeCode;//主力合约 A.DCE
		//SELECT * FROM DCE_D WHERE TRADEDATE <= '2016-05-24' AND SYMBOL = 'L.DCE' ORDER BY TRADEDATE DESC LIMIT 79
		String sql = "SELECT * FROM " +tableName +" WHERE TRADEDATE <= '" +
				tradeDay +"' AND SYMBOL = '" +SYMBOL +"' ORDER BY TRADEDATE DESC LIMIT 79";
		
		return XiaoTJdbcDriver.queryForList(sql);
	}


}
