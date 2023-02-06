package com.hjc.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjc.demo.mapper.UserMapper;
import com.hjc.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PagingTest {
    @Test
    public void testPaging() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        PageHelper.startPage(2, 3);
        List<User> students = mapper.selectAllUser();
        //查询之后 获取分页的所有数据
        PageInfo<User> page = new PageInfo<>(students, 1);
        System.out.println("page = " + page);
        students.forEach(System.out::println);
    }

    @Test
    public void testPagingLimit() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectAllUserLimit(1, 3);
        users.forEach(System.out::println);
    }
}
