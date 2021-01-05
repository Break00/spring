package com.jason.lee.jdbc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;


/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/12
 */
public class SpringJDBCTest {

    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
    JdbcTemplate template = ac.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    public void testQuery() {
        String sql = "select * from user where id = ?";
        // 将列名（字段名或别名）和实体类属性名映射
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = template.queryForObject(sql, new Object[]{1}, rowMapper);
        System.out.println(user.toString());

        sql = "select count(*) from user";
        Integer count = template.queryForObject(sql, Integer.class);
        System.out.println("统计：" + count);

        sql = "select * from user;";
        List<User> list = template.query(sql, rowMapper);
        for (User u : list) {
            System.out.println(u.toString());
        }
    }

}