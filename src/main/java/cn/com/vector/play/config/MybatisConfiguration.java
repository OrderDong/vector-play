package cn.com.vector.play.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import cn.com.vector.play.mybaits.DbContextHolder;
import cn.com.vector.play.mybaits.DynamicDataSourceResolver;
//import cn.com.vector.play.mybaits.PageInterceptor;
//import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.Getter;
import lombok.Setter;

/**
 *  mybaits
 * @author lwd
 *
 */
@Setter
@Getter
@Configuration
@MapperScan("cn.com.vector.play.dao")
@ConfigurationProperties(prefix = "mybaits")
@EnableTransactionManagement
//@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration {
	private String entity;
	private String configLocation;
	
    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;
   /* @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;*/

	@Bean
	public ServletRegistrationBean druidServlet(){
		return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	}
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions",
				"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
	  
//	@Bean
//	public DataSourceTransactionManager transactionManager() throws SQLException {
//		return new DataSourceTransactionManager(routingDataSource());
//	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(routingDataSource());
		sessionFactory.setConfigLocation(new ClassPathResource(configLocation));
		sessionFactory.setTypeAliasesPackage(entity);
		//sessionFactory.setPlugins(new Interceptor[]{new PageInterceptor()});
		return sessionFactory.getObject();
	}
	
	/**
	 * 添加JdbcTemplate支持
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() throws SQLException {
		return new JdbcTemplate(routingDataSource());
	}

	/**
	 *  添加NamedParameterJdbcTemplate支持sql中in查询
	 * @return
	 * @throws SQLException
	 */
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() throws SQLException {
		return new NamedParameterJdbcTemplate(jdbcTemplate());
	}
	
	private AbstractRoutingDataSource routingDataSource() throws SQLException {
		DynamicDataSourceResolver resolver = new DynamicDataSourceResolver();
		Map<Object, Object> dataSources = new HashMap<>();
		dataSources.put(DbContextHolder.DbType.MASTER, masterDataSource);
		/*dataSources.put(DbContextHolder.DbType.SLAVE, slaveDataSource);*/
		resolver.setTargetDataSources(dataSources);
		resolver.setDefaultTargetDataSource(masterDataSource);// 默认源
		resolver.afterPropertiesSet();
		return resolver;
	}
}