package com.jason.lee.annotation.config;

import com.jason.lee.annotation.bean.MyImportBeanDefinitionRegistrar;
import com.jason.lee.annotation.bean.MyImportSelector;
import com.jason.lee.annotation.bean.Person;
import com.jason.lee.annotation.bean.SchoolFactoryBean;
import com.jason.lee.annotation.bean.Student;
import com.jason.lee.annotation.condition.LinuxCondition;
import com.jason.lee.annotation.condition.WinCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author huanli9
 * @description
 * @date 2020/11/14 14:12
 */
//配置类==Spring配置文件
@Configuration
@ComponentScan("com.jason.lee.annotation.bean")  //可以自定义需要扫描的或排除的包、类
@Import({Student.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})  //快速导入组件
public class BeanConfig {

    // 懒加载  针对singleton容器启动时不创建Bean，第一次使用时创建并初始化
    @Lazy
    // 默认singleton IOC容器启动时创建对象 （单例）
    // prototype 获取时创建对象
    @Scope
    // 向Spring容器注册Bean，类型为方法返回值类型，id默认为方法名
    @Bean(name = "person")
    public Person person() {
        System.out.println("创建Person对象");
        return new Person("lee", 18);
    }

    // 符合条件则创建实例
    @Conditional({WinCondition.class})
    @Bean
    public Person Bill() {
        return new Person("Bill", 66);
    }

    @Conditional({LinuxCondition.class})
    @Bean
    public Person Linus() {
        return new Person("Linus", 48);
    }

    @Bean
    public SchoolFactoryBean schoolFactoryBean(){
        return new SchoolFactoryBean();
    }
}
