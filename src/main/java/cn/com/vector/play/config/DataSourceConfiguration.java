package cn.com.vector.play.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Configuration
//@ConfigurationProperties(prefix = "mybaits")
public class DataSourceConfiguration {

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;
//    
//	private String driver;
//	private String url;
//	private String username;
//	private String passwd;
//
//	private int maxActive;
//	private int initialSize;
//	private int maxWait;
//	private int minIdle;
//	private boolean removeAbandoned;
//	private int removeAbandonedTimeout;
//	private String connectionProperties;
//	private String validationQuery;
//	private boolean testWhileIdle;
//	private boolean testOnBorrow;
//	private boolean testOnReturn;
//	private boolean poolPreparedStatements;
//	private int maxPoolPreparedStatementPerConnectionSize;
//	
//	private String[] filters;
//    
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "druid.master")
    public DataSource masterDataSource() throws SQLException{
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setDriverClassName(this.driver);
//		dataSource.setUrl(this.url);
//		dataSource.setUsername(this.username);
//		dataSource.setPassword(this.passwd);
//		dataSource.setMaxActive(this.maxActive);
//		dataSource.setInitialSize(this.initialSize);
//		dataSource.setMaxWait(this.maxWait);
//		dataSource.setMinIdle(this.minIdle);
//		dataSource.setRemoveAbandoned(this.removeAbandoned);
//		dataSource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
//		dataSource.setValidationQuery(this.validationQuery);
//		dataSource.setTestWhileIdle(this.testWhileIdle);
//		dataSource.setTestOnBorrow(this.testOnBorrow);
//		dataSource.setTestOnReturn(this.testOnReturn);
//		dataSource.setPoolPreparedStatements(this.poolPreparedStatements);
//		dataSource
//				.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
//		dataSource.setConnectionProperties(this.connectionProperties);
//
//		if(filters != null && filters.length >0){
//			StringBuilder sb = new StringBuilder();
//			for (String s : filters) {
//				sb.append(s);
//			}
//			dataSource.setFilters(sb.toString());
//		}
//		return dataSource;
    	return DataSourceBuilder.create().type(dataSourceType).build();
    }
    
    
   /* @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "druid.slave")
    public DataSource slaveDataSource() throws SQLException{
    	return DataSourceBuilder.create().type(dataSourceType).build();
    }*/
}
