package cn.com.vector.play.mybaits;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *  获取数据源
 *
 */
public class DynamicDataSourceResolver extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }

}
