package com.jason.lee;

import com.jason.lee.entity.User;
import com.jason.lee.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {

    public static void main( String[] args ) throws IOException {
        String resource = "mybatis-config.xml";  // 数据源信息
        InputStream in = Resources.getResourceAsStream(resource);
        // 根据全局配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 代表和数据库的一次会话，用完关闭，非线程安全
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 普通方式
        User user = sqlSession.selectOne("userMapper.findUserById", 1);
        System.out.println(user);

        // 接口映射方式，mybatis为接口生成代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        user = mapper.getUserById(1);
        System.out.println(user);
    }
}
