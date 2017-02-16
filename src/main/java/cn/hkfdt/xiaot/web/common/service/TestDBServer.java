package cn.hkfdt.xiaot.web.common.service;

/**
 * Created by whyse
 * on 2017/2/16 10:21
 */
public interface TestDBServer {
    int transCASTest(String name);

    int updateCAS();
}
