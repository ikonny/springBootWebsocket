package cn.hkfdt.xiaot.websocket;

import cn.hkfdt.xiaot.web.common.globalinit.GlobalInfoHelperServer;
import cn.hkfdt.xiaot.websocket.conmng.CustomSubProtocolWebSocketHandler;
import cn.hkfdt.xiaot.websocket.interceptors.InboundChannelIntercepter;
import cn.hkfdt.xiaot.websocket.interceptors.OutboundChannelIntercepter;
import cn.hkfdt.xiaot.websocket.interceptors.XiaoTShareInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

import java.util.List;

/*
 * 1.@EnableWebSocketMessageBroker注解表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思。 
2.registerStompEndpoints方法表示注册STOMP协议的节点，并指定映射的URL。 
3.stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();这一行代码用来注册STOMP协议节点，同时指定使用SockJS协议。 
4.configureMessageBroker方法用来配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
 */
@Configuration
@EnableWebSocketMessageBroker  //STOMP client
public class WebSocketConfig extends WebSocketMessageBrokerConfigurationSupport implements WebSocketMessageBrokerConfigurer {

    static Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);
    @Autowired
    GlobalInfoHelperServer globalInfoHelperServer;
	//这个先启用
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //=================================================
        ThreadPoolTaskScheduler te = new ThreadPoolTaskScheduler();
        te.setPoolSize(1);
        te.setThreadNamePrefix("wss-heartbeat-thread-");
        te.initialize();
        int heartBeatTime = 1000*10;
//        config.enableSimpleBroker("/").setHeartbeatValue(new long[]{heartBeatTime, heartBeatTime})
//                .setTaskScheduler(te);
        //=============================================================
//        config.setUserDestinationPrefix("/user");//设置点对点通信订阅前缀，默认的
    	config.enableSimpleBroker("/queue", "/topic")
                .setHeartbeatValue(new long[]{heartBeatTime,heartBeatTime})
                .setTaskScheduler(te);//我发给客户端，客户端需要订阅的
        //这个可以没有，请求和订阅就是一个url了
//        config.setApplicationDestinationPrefixes("/req");//客户端请求过来的

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	//这是一条连线
    	XiaoTShareInterceptor xiaoTShareInterceptor = new XiaoTShareInterceptor();//这个是连接建立时候的
        registry.addEndpoint("/xiaots").addInterceptors(xiaoTShareInterceptor).setAllowedOrigins("*");
//        .withSockJS().setStreamBytesLimit(1000 * 1024);//客户端是SockJS就使用这个
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.setSendTimeLimit(20*1000);
        registry.setMessageSizeLimit(1024*1024);//The default value is 64K (i.e. 64 * 1024)
        registry.setSendBufferSizeLimit(1024*1024);//default value is 512K (i.e. 512 * 1024).
        super.configureWebSocketTransport(registry);
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration channelRegistration) {
        //拦截websoket的消息，消息类型和消息体
        if(globalInfoHelperServer.isTransLogon) {
            InboundChannelIntercepter interceptors = new InboundChannelIntercepter();
            channelRegistration.setInterceptors(interceptors);
            super.configureClientInboundChannel(channelRegistration);
            System.out.println("configureClientInboundChannel");
        }

    }
    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        if(globalInfoHelperServer.isTransLogon) {
            OutboundChannelIntercepter interceptors = new OutboundChannelIntercepter();
            registration.setInterceptors(interceptors);
            super.configureClientOutboundChannel(registration);
            System.out.println("configureClientOutboundChannel");
        }
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        super.addReturnValueHandlers(returnValueHandlers);
    }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        return super.configureMessageConverters(messageConverters);
    }

    //============================================================

    /**
     * 拦截用户的sessionHander，做索引
     * @return
     */
//    @Bean
    public WebSocketHandler subProtocolWebSocketHandler() {
        return new CustomSubProtocolWebSocketHandler(clientInboundChannel(), clientOutboundChannel());
    }

}