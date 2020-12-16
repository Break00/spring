package com.jason.lee;

import com.jason.lee.entity.User;
import com.jason.lee.mapper.DynamicSQLMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DynamicSQLTest {

    public static void main( String[] args ) throws IOException {
        String resource = "mybatis-config.xml";  // 数据源信息
        InputStream in = Resources.getResourceAsStream(resource);
        // 根据全局配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 代表和数据库的一次会话，用完关闭
        // 非线程安全
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        // 查询的时候如果某些条件不存在可能产生sql拼装问题
        // 1、给where后面加上1=1
        // 2、使用<where>标签，where只会去掉第一个多出来的and或者or
        // 3、使用<trim>标签，<trim prefix="where" suffixOverrides="and">...</trim>
        mapper.getUser(new User(0,"M",0));

        mapper.getUserLike("M");

        System.out.println();
    }
}
