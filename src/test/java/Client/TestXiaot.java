package Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
/queue/game/doReady
请求 ：  {"userId":"g-HXe3eQ7Cw3TJW3rFbKIL","userType":3,"gameId":"dc36efe2-e8fd-45f6-8d6e-cfceb2ba5fa8",
"headimgurl":"//img.investmaster.cn/998af7f38430482bb74fdc0f0a8171fe.png","userName":"setr"}

/user/queue/game/doReady
返回  ： {"rspCode":200,"data":{gameName:"AAA比赛"}}   其他就是准备失败

 */
public class TestXiaot {
    private static Logger logger = LoggerFactory.getLogger(TestXiaot.class);
    public static ExecutorService executorService = Executors.newFixedThreadPool(200);
    static String dev = "devxiaot.forexmaster.cn/xiaots";
    static String local = "localhost:12306/xiaots";
    static String test = "testxiaot.forexmaster.cn/xiaots";
    static String currentEnv = test;
    static List<ClientXiaot>  listXiaot = new ArrayList<>(500);

    public static void main(String[] args) {
        String userId = "userId_";
        String gameId = "9d84cd09-3d01-4276-a90e-99ffe88c52a7";
        String headimgurl = "//img.investmaster.cn/998af7f38430482bb74fdc0f0a8171fe.png";
        int userType = 3;

        for(int i=100;i<150;i++) {
            String userIdT = userId+i;
            String userName = userIdT;
            executorService.submit(()->{
                newClient(gameId, userIdT, userType, headimgurl, userName);
            });
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void newClient(String gameId, String userId, int userType, String headimgurl, String userName) {

        ClientXiaot clientXiaot = new ClientXiaot(gameId,userId,userType,headimgurl,userName);
        listXiaot.add(clientXiaot);
        clientXiaot.connect(currentEnv);

        clientXiaot.doReady();//必须要准备，准备后进入
        clientXiaot.subReadyInfoTest();
        clientXiaot.subListInfoTest();
        clientXiaot.subTimePointTest();
    }
}
