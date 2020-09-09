package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//spring和数据库连接相关 配置
public class jdbcConfig {


    @Value("${jdbc.driver}")
    private String diver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //配置QueryRunner
    //TODO

    @Bean(name = "runner")

    public QueryRunner createQueryRunner(@Qualifier("ds1") DataSource dataSource)
    {

        return new QueryRunner(dataSource);
    }

    @Bean(name = "ds1")
    public DataSource createDataSource()
    {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(diver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);

            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "ds2")
    public DataSource createDataSource2()
    {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(diver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);

            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
