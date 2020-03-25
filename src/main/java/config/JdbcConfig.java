package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

@Configuration //不作为参数此注释必写！
public class JdbcConfig {

    @Value("${jdbcDriver}")
    private String driver;

    @Value("${jdbcUrl}")
    private String url;

    @Value("${jdbcUserName}")
    private String userName;

    @Value("${jdbcPassWord}")
    private String passWord;


    @Bean(name = "dataSource")
    @Scope("prototype")
    public DataSource crearDataSource(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(userName);
            ds.setPassword(passWord);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
