package cn.hkfdt.xiaot.web.common.service.impl;

import cn.hkfdt.xiaot.mybatis.mapper.ltschina.AuthMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.SchoolMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.UserTypeMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.*;
import cn.hkfdt.xiaot.web.common.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by whyse
 * on 2017/2/10 10:17
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthMapper authMapper;
    @Autowired
    SchoolMapper schoolMapper;
    @Autowired
    UserTypeMapper userTypeMapper;

    //==============================================================
    @Override
    public ConcurrentHashMap<String,Map<String, Object>> getFdtId2AuthExInfo(List<String> fdtIds) {
        int size = fdtIds.size();
//        Map<String, Map<String, Object>> fdtId2AuthExInfoMap = new HashMap<>(size);
        ConcurrentHashMap<String,Map<String, Object>> fdtId2AuthExInfoMap = new ConcurrentHashMap<>(size);
        List<String> listSchoolKey = new ArrayList<>(size);

        AuthExample example = new AuthExample();
        example.createCriteria().andUseridIn(new ArrayList<String>(fdtIds));
        List<Auth> listAuth = authMapper.selectByExample(example);
        if(!listAuth.isEmpty()) {
            for (Auth auth : listAuth) {
                Map<String, Object> item = new HashMap<>(5);
                item.put("auth", auth);//原生auth表对象入map

                listSchoolKey.add(auth.getSchoolKey());

                fdtId2AuthExInfoMap.put(auth.getUserid(), item);
            }
            Map<String, School> mapSchools = getSchoolsByIds(listSchoolKey);
            Map<String, Boolean> mapIsVip = getVipByIds(fdtIds);

            fdtId2AuthExInfoMap.forEachEntry(4,item ->{
                Map<String, Object> temp = item.getValue();
                Auth auth = (Auth) temp.get("auth");
                String sclKey = auth.getSchoolKey();
                String fdtId = auth.getUserid();
                boolean isVip = mapIsVip.containsKey(fdtId);
                temp.put("school",mapSchools.get(sclKey));
                temp.put("vip",isVip);
            });

            return fdtId2AuthExInfoMap;
        }

        return null;
    }

    @Override
    public Auth getAuthByFdtId(String fdtId) {
        AuthExample example = new AuthExample();
        example.createCriteria().andUseridEqualTo(fdtId);
        List<Auth> listAuth = authMapper.selectByExample(example);
        if(listAuth.isEmpty())
            return null;
        else
            return listAuth.get(0);
    }

    /**
     * @return 返回是vip的map,key是fdtid
     * @author whyse
     * @Date 2017/2/13 14:51
    */
    private Map<String,Boolean> getVipByIds(List<String> fdtIds) {
        Map<String,Boolean> mapTar = new HashMap<>(fdtIds.size());
        UserTypeExample example = new UserTypeExample();
        example.createCriteria().andTypeIdIsNotNull().andTypeIdNotEqualTo("01")
                .andUserIdIn(fdtIds);
        List<UserType> listUT = userTypeMapper.selectByExample(example);
        listUT.forEach((item)->{mapTar.put(item.getUserId(),true);});
        return mapTar;
    }
    /**
     * @return 返回key对应的学校对象，如果没有key就证明没有对象
     * @author whyse
     * @Date 2017/2/13 14:48
    */
    private Map<String,School> getSchoolsByIds(List<String> listSchoolKey) {
        if(listSchoolKey==null || listSchoolKey.isEmpty()){
            return null;
        }
        SchoolExample schoolExample = new SchoolExample();
        schoolExample.createCriteria().andSchoolKeyIn(listSchoolKey);
        List<School> listScl = schoolMapper.selectByExample(schoolExample);
        if(!listScl.isEmpty()) {
            Map<String,School> mapTar = new HashMap<>(listScl.size());
            listScl.forEach((item)->{mapTar.put(item.getSchoolKey(),item);});
            return mapTar;
        }else{
            return null;
        }
    }
}
