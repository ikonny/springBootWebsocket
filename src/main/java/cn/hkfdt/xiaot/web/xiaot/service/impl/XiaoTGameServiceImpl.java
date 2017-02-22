package cn.hkfdt.xiaot.web.xiaot.service.impl;

import cn.hkfdt.xiaot.mybatis.model.ltschina.Auth;
import cn.hkfdt.xiaot.web.Filters.LoginFilter;
import cn.hkfdt.xiaot.web.common.service.AuthService;
import cn.hkfdt.xiaot.web.xiaot.service.XiaoTGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

/**
 * author:xumin 
 * 2016-12-15 下午4:12:42
 */
@Service
public class XiaoTGameServiceImpl implements XiaoTGameService {


	@Autowired
	AuthService authService;


	//=================================================
	@Override
	public Map<String, Object> getGameUser(String fdtId) {
		Map<String, Object>  mapTar = new HashMap<>(3);
		if(LoginFilter.isNotLogin(fdtId)){
			fdtId = XiaoTHelp.xiaoTGuest;
			mapTar.put("userName","游客");
			mapTar.put("userId",fdtId);
			mapTar.put("userType",3);
		}else{
			Auth auth = authService.getAuthByFdtId(fdtId);
			mapTar.put("userName",auth.getUsername());
			mapTar.put("userId",fdtId);
			mapTar.put("userType",1);
		}
		return mapTar;
	}
}
