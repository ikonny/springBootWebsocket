package cn.hkfdt.xiaot.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by whyse
 * on 2017/2/23 17:18
 */
public class XiaoTCommon {
    /**
     * 系统共享的额外的线程池，用于异步并发
     */
    public static ExecutorService executorService = Executors.newCachedThreadPool();
}
