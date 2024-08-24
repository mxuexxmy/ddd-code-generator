package com.mxue.boot.config;

import com.mxue.boot.dao.*;
import com.mxue.boot.utils.AdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Zhang Liqiang
 * @email 18945085165@163.com
 * @date 2021/11/30
 * @description: 数据库配置
 **/
@Configuration
public class DbConfig {

    @Value("${aimin.database: mysql}")
    private String database;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;

    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;

    @Autowired
    private SQLServerGeneratorDao sqlServerGeneratorDao;

    @Autowired
    private PostgreSQLGeneratorDao postgreSQLGeneratorDao;


    @Bean
    @Primary
    public GeneratorDao getGeneratorDao() {
        if ("mysql".equalsIgnoreCase(database)) {
            return mySQLGeneratorDao;
        } else if ("oracle".equalsIgnoreCase(database)) {
            return oracleGeneratorDao;
        } else if ("sqlserver".equalsIgnoreCase(database)) {
            return sqlServerGeneratorDao;
        } else if ("postgresql".equalsIgnoreCase(database)) {
            return postgreSQLGeneratorDao;
        } else {
            throw new AdminException("不支持当前数据库：" + database);
        }
    }


}
