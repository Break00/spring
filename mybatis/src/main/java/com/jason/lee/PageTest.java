package com.jason.lee;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.lee.entity.User;
import com.jason.lee.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class PageTest {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";  // 数据源信息
        InputStream in = Resources.getResourceAsStream(resource);
        // 根据全局配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 代表和数据库的一次会话，用完关闭，非线程安全
        // 设置true自动提交，否则显式调用sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 分页信息
        Page<Object> page = PageHelper.startPage(1, 5);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        // 分页信息
        PageInfo<User> pageInfo = new PageInfo<>(users);

        users.forEach(System.out::println);
        System.out.println("当前页码：" + page.getPageNum());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("每页记录数：" + page.getPageSize());
        System.out.println("总页码：" + page.getPages());
    }
}
