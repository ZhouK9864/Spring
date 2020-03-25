package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.PooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.awt.*;

/*
 * 配置类 和 bean.xml的作用一致
 * Configuration 该注解表示 当前类是一个配置类
 * ComponentScan 作用：用于通过注解指定Spring在创建容器时要扫描的包 相当于在xml中的
 *                      <context:component-scan base-package="com.Myclud"></context:component-scan>
 * Bean 把当前方法的返回值当作bean对象放入到Spring容器中
 *      属性：name：用于指定bean的id默认值为当前方法的名称。
 *      细节：当使用注解配置方法时，如果方法有参数，Spring框架会从容器中找bean对象，查找方式和Autowired一样
 */

@Configuration
@ComponentScan("com.Myclud")
public class SpringConfiguration {

    @Bean(name = "runner")
    public QueryRunner creatQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }//用于创建runner对象，并放入容器中

    @Bean(name = "dataSource")
    public DataSource crearDataSource(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
            ds.setUser("root");
            ds.setPassword("admin");
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
