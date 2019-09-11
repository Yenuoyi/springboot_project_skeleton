package com.example.skeleton.common.datasource;

/**
 * 数据源枚举
 * @author yebing
 */
public enum DataSourceEnum {
    MASTER_DATASOURCE("masterDatasource"),
    SLAVE_DATASOURCE("slaveDatasource");

    DataSourceEnum(String name){
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
