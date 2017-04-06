package cn.hkfdt.xiaot.common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个支持定时回收超时的内存数据的map
 * Created by whyse
 * on 2017/2/23 20:02
 */
public class CacheMapXM {
    public ConcurrentHashMap<String, XmItem> mapMatchInfo = null;
    int revoverTime = 60;//回收间隔时间
    CahceXMListen cahceXMListen;
    /**
     * @param size  可存放对象大小
     * @param revoverTime 回收间隔时间
     */
    public CacheMapXM(int size, int revoverTime) {
        mapMatchInfo = new ConcurrentHashMap<>(size);
        this.revoverTime = revoverTime;
        init();
    }
    public CacheMapXM(){
        mapMatchInfo = new ConcurrentHashMap<>(500);
        init();
    }

    /**
     * 这个任务线程肯定会执行完毕
     */
    private void init() {
        //回收任务
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    long time = System.currentTimeMillis();
                    mapMatchInfo.forEachEntry(2,item->{
                        XmItem xmItem = item.getValue();
                        if(xmItem.endTime<=time){
                            mapMatchInfo.remove(xmItem.key);
                            if (cahceXMListen != null) {
                                cahceXMListen.timeOverEvent(xmItem.item,xmItem.key);
                            }
                        }
    //                    System.err.println("回收一次，结束时间:"+xmItem.endTime+"   现在时间:"+time);
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 10, revoverTime, TimeUnit.SECONDS);
    }
    //==========================================================================================
    public void addListener(CahceXMListen cahceXMListen){
        this.cahceXMListen = cahceXMListen;
    }
    //==========================================================================================
    /**
     * 如果有相同key，覆盖后，时间也同时计算
     * @param key
     * @param item 存放的对象
     * @param remainTime 停留的秒数
     */
    public void put(String key, Object item, int remainTime) {
        if(mapMatchInfo.containsKey(key)){

            XmItem xmItem = mapMatchInfo.get(key);
            xmItem.endTime = remainTime*1000+System.currentTimeMillis();
            xmItem.item = item;
            return ;
        }
        XmItem xmItem = new XmItem();
        xmItem.endTime = remainTime*1000+System.currentTimeMillis();
        xmItem.item = item;
        xmItem.key = key;
        mapMatchInfo.put(key,xmItem);
    }
    public Object get(String key) {
        XmItem xmItem = mapMatchInfo.get(key);
        if(xmItem!=null){
            return xmItem.item;
        }
        return null;
    }
    public void remove(String key) {
        mapMatchInfo.remove(key);
    }
}

//=====================================================================================
class XmItem{
    String key;
    Object item;
    long endTime;
}
