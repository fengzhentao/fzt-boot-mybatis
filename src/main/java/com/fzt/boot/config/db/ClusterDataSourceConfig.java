package com.fzt.boot.config.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @Description 从数据源
 * @Author fengzt
 * @Date 2019/3/29
 * @Version 1.0
 **/
@Configuration
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionTemplateRef = "clusterSqlSessionTemplate")
public class ClusterDataSourceConfig {

    static final String PACKAGE = "com.fzt.boot.mapper.cluster";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.cluster")
    public DataSource clusterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory clusterSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(clusterDataSource());
        String MAPPER_LOCATION = "classpath:mapping/cluster/*.xml";
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager clusterDataSourceTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean
    public SqlSessionTemplate clusterSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(clusterSqlSessionFactory());
    }
}
