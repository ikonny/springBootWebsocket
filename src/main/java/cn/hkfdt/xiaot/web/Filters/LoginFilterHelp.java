package cn.hkfdt.xiaot.web.Filters;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class LoginFilterHelp {
	
	/**
	 * 不需要登录的uri写入
	 */
	static List<String> ListNotloginURI = new ArrayList<String>(100);

	static List<String> high_securites_url = new ArrayList<String>(100);


	static {
		ListNotloginURI.add("/xiaoth/initTQuestions");//尝试初始化数据库中小T题库 xm=right
		ListNotloginURI.add("/xiaoth/getXiaotMasterList");
		ListNotloginURI.add("/xiaoth/xiaot");
		ListNotloginURI.add("/xiaoth/getXiaotForceAnalysis");
		ListNotloginURI.add("/xiaoth/getXiaotRecords");
		ListNotloginURI.add("/xiaoth/xiaotTraining");
		ListNotloginURI.add("/xiaoth/getQrCode");//二维码

		//============以下是测试的时候添加的==========
		ListNotloginURI.add("/xiaoth");//测试使用，可以不过滤任何http请求
		ListNotloginURI.add("/xiaoth/wss");
		
	}

	/**
	 * @param args
	 * author:xumin 
	 * 2016-4-12 下午5:53:39
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 不需要登录的uri写入数组就行
	 * @param request
	 * @return
	 * author:xumin 
	 * 2016-4-12 下午6:01:31
	 */
	public static boolean isNotLoginURI(HttpServletRequest request) {
//		if(request!=null)
//			return true;//这是测试代码，所有的都可以访问
		String requestURI = request.getRequestURI();
		for(String uri:ListNotloginURI){
			if(requestURI.contains(uri))
				return true;
		}
		System.err.println(requestURI);
		return false;
	}

	/**
	 * 是否是需要高安全级别，真实校验token的url
	 * @return
     */
	public static boolean isHighSecurities(String url){
		return high_securites_url.contains(url);
	}

	public static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

}
