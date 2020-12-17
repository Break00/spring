package com.jason.lee;

import com.jason.lee.entity.Product;
import com.jason.lee.entity.User;
import com.jason.lee.mapper.ProductMapper;
import com.jason.lee.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {

    public static void main( String[] args ) throws IOException {
        String resource = "mybatis-config.xml";  // 数据源信息
        InputStream in = Resources.getResourceAsStream(resource);
        // 根据全局配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 代表和数据库的一次会话，用完关闭
        // 非线程安全
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = mapper1.getUserById(4);
        sqlSession1.close();

        // 第二次查询是从二级缓存中拿到的数据
        User user2 = mapper2.getUserById(4);
        sqlSession2.close();

        // 手动清除一级缓存
        // sqlSession.clearCache();
        //User user1 = mapper1.getUserById(4);

        System.out.println(user1==user2);

    }
}
