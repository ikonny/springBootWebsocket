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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by whyse
 * on 2017/2/14 9:34
 */
@Configuration
@MapperScan(basePackages = "cn.hkfdt.xiaot.mybatis.mapper.fxchina", sqlSessionTemplateRef  = "fxChinaSqlSessionTemplate")
public class DBFXChinaConf {
    @Bean(name = "fxChinaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.fxChina")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "fxChinaSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("fxChinaDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/fxChina/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "fxChinaTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("fxChinaDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "fxChinaSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("fxChinaSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
