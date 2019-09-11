package com.example.skeleton.common.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.*;

/**
 * 数据源配置
 * @author yebing
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.example.skeleton.dao"}, sqlSessionFactoryRef   = "sqlSessionFactory")
public class DataSourceConfig {
    /**
     * 配置mapper的扫描，找到所有的mapper.xml映射文件
     */
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;


    /**
     * 加载全局的配置文件
     */
    @Value("${mybatis.configLocation}")
    private String configLocation;

    /**
     * 生成主数据源bean，通过@ConfigurationProperties导入数据源配置
     * @return
     */
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource(){
        DruidDataSource masterDataSource = DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
        masterDataSource.setName("masterDataSource");
        return masterDataSource;
    }

    /**
     * 生成从数据源bean，通过@ConfigurationProperties导入数据源配置
     * @return
     */
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource(){
        DruidDataSource slaveDataSource = DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
        slaveDataSource.setName("slaveDataSource");
        return slaveDataSource;
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(16);
        dsMap.put(DataSourceEnum.MASTER_DATASOURCE.getName(), masterDataSource());
        dsMap.put(DataSourceEnum.SLAVE_DATASOURCE.getName(), slaveDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }
    @Bean
    public PlatformTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * @param dynamicDataSource
     * @return
     * @throws Exception
     */
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        //扫描mapper配置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        //扫描mybatis配置文件
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(configLocation) );
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        /* 使用上面配置的Factory */
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

}
