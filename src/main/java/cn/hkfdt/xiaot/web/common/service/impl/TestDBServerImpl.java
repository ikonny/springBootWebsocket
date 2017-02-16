package cn.hkfdt.xiaot.web.common.service.impl;

import cn.hkfdt.xiaot.mybatis.mapper.ltschina.ForceAnalysisExtendsMapper;
import cn.hkfdt.xiaot.mybatis.mapper.ltschina.TRecordExtendsMapper;
import cn.hkfdt.xiaot.mybatis.model.ltschina.ForceAnalysis;
import cn.hkfdt.xiaot.mybatis.model.ltschina.ForceAnalysisExample;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TRecord;
import cn.hkfdt.xiaot.web.common.service.TestDBServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Autowired 没有的bean 会报错：com.mysql.jdbc.AbandonedConnectionCleanupThread.run
 * Created by whyse
 * on 2017/2/16 10:21
 */
@Service
public class TestDBServerImpl implements TestDBServer {
    Logger logger = LoggerFactory.getLogger(TestDBServerImpl.class);
    //注意了，这边只允许有一个类实现了这个接口
    @Autowired
    ForceAnalysisExtendsMapper forceAnalysisMapper;
    @Autowired
    TRecordExtendsMapper tRecordMapper;
    @Autowired
    TestDBServer testDBServer;//可以把自己注入进来，事务有效


    volatile Integer sleepTime = 3;

    /*
    2017-02-16 15:23:21.595  INFO 9296 --- [      Thread-11] c.h.x.w.c.service.impl.TestDBServerImpl  :  version:0操作成功
2017-02-16 15:23:22.614  INFO 9296 --- [      Thread-10] c.h.x.w.c.service.impl.TestDBServerImpl  :  version:0乐观锁失败，被其他事务修改
2017-02-16 15:23:22.647  INFO 9296 --- [      Thread-10] c.h.x.w.c.service.impl.TestDBServerImpl  : 11 再尝试一次
2017-02-16 15:23:23.708  INFO 9296 --- [      Thread-10] c.h.x.w.c.service.impl.TestDBServerImpl  :  version:1操作成功
     */
    @Override
    public int transCASTest(String name) {
        int time = 2;
        //不仅要自旋转，而且要是出口，比如次数
        while(testDBServer.updateCAS()!=1 && time>0){
            logger.info(name+" 再尝试一次");
            --time;
        }
        return 0;
    }
    @Transactional
    @Override
    public int updateCAS() {
        //1.乐观查询记录的版本等信息
        ForceAnalysisExample example = new ForceAnalysisExample();
        example.createCriteria().andFdtIdEqualTo("xumin");//唯一索引
        ForceAnalysis force = forceAnalysisMapper.selectByExample(example).get(0);

        //模拟在这边阻塞,两个线程总会在一个版本上,阻塞不同的时间
        try {
            int sleep;
            synchronized (sleepTime){
                sleep = sleepTime--*1000;
            }
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //2.乐观更新记录(可以减少数据库回滚压力：多个事务更新一个版本的时候，只有一个事务成功，其他失败后不用插入其他
        // 消息的回滚，而且能更快的自旋转锁开始,操作放前面有利于提高吞吐量)
        force.setFdtScore(force.getFdtScore()+1);
        int version = force.getVERSION();
        force.setVERSION(version+1);//不要忘了版本号加1
        example.clear();
        example.createCriteria().andFdtIdEqualTo("xumin").andVERSIONEqualTo(version);
        int count = forceAnalysisMapper.updateByExample(force,example);

        //3.成功后，再轻松的插入
        if (count == 1) {
            logger.info(" version:" + version + "操作成功");
            TRecord record = new TRecord();
            record.setSymbol("--");
            record.setTradeTime("--");
            record.setReturnRate(0f);
            record.setVolatility(0f);
            record.setType(0);
            record.setVERSION(version);
            record.setFdtId("xumin");
            if(tRecordMapper.insert(record)!=1){
                throw new RuntimeException();
            }
            return 1;
        } else {
            logger.info(" version:" + version + "乐观锁失败，被其他事务修改");
        }
        return 0;
    }
}
