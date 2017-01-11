package cn.hkfdt.xiaot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = {"com.hxkj.waychat.dao"})
@ServletComponentScan
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    private static Logger logger = Logger.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        //org.apache.tomcat.jdbc.pool.DataSource
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(@Autowired DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

//		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:/mybatis/config.xml"));
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*Mapper.xml"));
        // classpath*:**/*Mapper.xml
        Resource[] mapperLocations = resolver.getResources("classpath*:**/*Mapper.xml");//{"classpath*:**/*Mapper.xml"};
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        //这个就是生成model的地址包
        sqlSessionFactoryBean.setTypeAliasesPackage("cn.hkfdt.xiaot.mybatis.model");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        //--------------------
        return sqlSessionFactory;
    }

    @SuppressWarnings("deprecation")
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(@Autowired SqlSessionFactory sqlSessionFactory) {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactory(sqlSessionFactory);
        mapperScannerConfigurer.setBasePackage("cn.hkfdt.xiaot.mybatis.mapper");
        return mapperScannerConfigurer;
    }

    //===============以上就是原本定义在xml里面的bean=================================

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(12306);
    }

}
