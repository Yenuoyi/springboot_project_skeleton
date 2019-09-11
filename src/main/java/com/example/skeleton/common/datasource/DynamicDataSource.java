package com.example.skeleton.common.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * @author yebing
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);
    /** 使用线程安全的ThreadLocal记录当前线程数据源key*/
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();
    /**
     * 设置数据库key
     * @param key
     */
    public static void putDataSourceKey(String key){
        log.debug("切换到{}数据源", key);
        holder.set(key);
    }

    /**
     * 获取数据源key
     * @return
     */
    public static String getDataSourceKey(){
        return holder.get();
    }

    /**
     * 删除数据源key
     */
    public static void removeDataSourceKey(){
        holder.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("切换数据源为:====", getDataSourceKey());
        return getDataSourceKey();
    }
}
