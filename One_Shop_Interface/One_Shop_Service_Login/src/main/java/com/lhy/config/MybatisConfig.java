package com.lhy.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan("com.lhy.dao")
public class MybatisConfig {
	
	@Bean
	@ConfigurationProperties(prefix="db")
	public DataSource initDataSource() {
		return new DataSource();
	}
	
	@Bean
	public SqlSessionFactory initMybatis() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		sqlSessionFactoryBean.setDataSource(initDataSource());
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath:/mybatis/*.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager initTransacationManager() {
		return new DataSourceTransactionManager(initDataSource());
	}

}
