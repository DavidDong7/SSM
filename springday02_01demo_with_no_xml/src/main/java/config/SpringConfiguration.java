package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
//spring全注解配置
//ComponentScan作用：指定spring创建容器时要扫的包
    //属性：value和basePackages一样，都是指定要扫的包
    //等价于xml中配置<context：component-scan base-package = "com.neusoft">
//        </context:component-scan>
    //Bean
        //作用：把当前方法的返回值作为bean对象存入spring的IOC容器中
//属性 name 指定bean的id 不写时与component一样  默认当前方法名
//细节：当我们使用注解配置时，如果方法有参数，spring框架去容器中查找
//有没有可用的bean对象，查找的方式和autowired的作用是一样的


//@ComponentScan(basePackages = "com.neusoft")
//@ComponentScan({ "com.neusoft"})
@ComponentScan("com.neusoft")
@Import(jdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}










