package common;

import cn.hkfdt.xiaot.common.CacheMapXM;

/**
 * Created by whyse
 * on 2017/2/28 11:15
 */
public class CacheTest {
    public static void main(String[] args) {
        CacheMapXM cacheMapXM = new CacheMapXM();
        cacheMapXM.addListener((Object item,String key)->{
            System.err.println(item+"__超时,已经被回收了key:"+key);
        });
        cacheMapXM.put("key","我是个对象",22);
    }
}
