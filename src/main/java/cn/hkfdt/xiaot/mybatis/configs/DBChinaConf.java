package cn.hkfdt.xiaot.mybatis.configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by whyse
 * on 2017/2/14 9:34
 */
@Configuration
@MapperScan(basePackages = "cn.hkfdt.xiaot.mybatis.mapper.ltschina", sqlSessionTemplateRef  = "ltsChinaSqlSessionTemplate")
public class DBChinaConf {
    @Bean(name = "ltsChinaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ltsChina")
    @Primary  //需要写默认数据源配置
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ltsChinaSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("ltsChinaDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/ltsChina/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "ltsChinaTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("ltsChinaDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ltsChinaSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("ltsChinaSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
