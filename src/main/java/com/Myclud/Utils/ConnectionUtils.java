package com.Myclud.Utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接工具类
 */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Resource
    private DataSource dataSource;

    public Connection getThreadConnection(){
        //先从threadlocal上获取
        try {
            Connection conn = tl.get();
            if (conn == null) {
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void connectionRemove(){
        tl.remove();
    }

}
