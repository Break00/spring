package com.jason.lee;

import com.jason.lee.entity.User;
import com.jason.lee.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author huanli9
 * @description
 * @date 2020/12/22 10:56
 */
public class BatchTest {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";  // 数据源信息
        InputStream in = Resources.getResourceAsStream(resource);
        // 根据全局配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 批量操作(预编译sql一次，设置参数多次)
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (int i=0;i<100;i++){
            mapper.saveUser(new User(UUID.randomUUID().toString().substring(0,3),16));
        }
        sqlSession.commit();
    }
}
