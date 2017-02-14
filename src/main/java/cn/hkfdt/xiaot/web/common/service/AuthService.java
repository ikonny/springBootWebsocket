package cn.hkfdt.xiaot.web.common.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by whyse
 * on 2017/2/10 10:17
 */
public interface AuthService {
    /**
     * @param fdtIds
     * @return 以fdtId 为key 后面跟一个map,里面有anth信息和school，是否vip等扩展信息
     * @author whyse
     * @Date 2017/2/10 11:04
    */
    ConcurrentHashMap<String,Map<String, Object>> getFdtId2AuthExInfo(List<String> fdtIds);
}
