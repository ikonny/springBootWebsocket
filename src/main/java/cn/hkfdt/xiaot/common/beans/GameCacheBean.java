package cn.hkfdt.xiaot.common.beans;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by whyse
 * on 2017/2/23 17:50
 */
public class GameCacheBean implements Serializable {
    /**
     *比赛综合数据,就是客户端所需要的全部数据
     * fdtId,market,tradeTime:2016.07.21,key:DCE#JD#2016-07-21
     * jsonData (history,today)
     */
    public Map<String, Object> mapTar;
    /**
     * 一个没有jsonData的题目结构
     */
    public TQuestions tQuestions;
    /**
     * 比赛数据，含有比赛id，人数，比赛名称等
     */
    public TGame tGame;
}
