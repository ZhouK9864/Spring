package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.PooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.awt.*;

/*
 * 配置类 和 bean.xml的作用一致
 * Configuration 该注解表示 当前类是一个配置类
 *              细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注释可以不写。作为另一个包被主配置文件（参数）扫描时需要加上这个注解。
 * ComponentScan 作用：用于通过注解指定Spring在创建容器时要扫描的包 相当于在xml中的
 *                      <context:component-scan base-package="com.Myclud"></context:component-scan>
 * Bean 把当前方法的返回值当作bean对象放入到Spring容器中
 *      属性：name：用于指定bean的id默认值为当前方法的名称。
 *      细节：当使用注解配置方法时，如果方法有参数，Spring框架会从容器中找bean对象，查找方式和Autowired一样
 * PropertySource 作用：用于指定propertySource文件的位置 classpath表示类路径下
 */

@Configuration
@ComponentScan("com.Myclud") //{,"config"}扫描子包，区分出主配置文件和子配置文件。
@Import(JdbcConfig.class)    //不扫描的话就用这个注解。
@PropertySource("classpath:JdbcConfig.properties")
@EnableAspectJAutoProxy
public class SpringConfiguration {

    @Bean(name = "runner")
    public QueryRunner creatQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }//用于创建runner对象，并放入容器中



}
