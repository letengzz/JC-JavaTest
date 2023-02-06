package com.hjc.test;

import com.hjc.demo.mapper.StudentMapper;
import com.hjc.demo.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class SpecialTest {
    @Test
    public void testSelectByAlias() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //执行查询
        List<Student> students = mapper.selectAllByAlias();
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectByResultMap() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //执行查询
        List<Student> students = mapper.selectAllByResultMap();
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectBySettings() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //执行查询
        List<Student> students = mapper.selectAllBySettings();
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectByLike() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //执行查询
        List<Student> students = mapper.selectStuByLike("小");
        students.forEach(System.out::println);
    }

    @Test
    public void testDeleteMore() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //执行批量删除
        int result = mapper.deleteMore("1,2,3");
        System.out.println("result = " + result);
    }

    @Test
    public void testSelectByTable() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //查询指定表中的数据
        List<Student> students = mapper.getAllStu("student");
        students.forEach(System.out::println);
    }

    @Test
    public void testOneQueryToBean() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println("student = " + student);

    }

    @Test
    public void testOneQueryToList() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByIdToList(1);
        students.forEach(System.out::println);
    }

    @Test
    public void testCount() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Integer count = mapper.getCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testAllQueryToList() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAllToList();
        students.forEach(System.out::println);
    }

    @Test
    public void testOneQueryToMap() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<Integer, Object> map = mapper.getStuByIdToMap(1);
        System.out.println("map = " + map);
    }

    @Test
    public void testAllQueryToMap() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map = mapper.getStuAllToMap();
        System.out.println("map = " + map);
    }

    @Test
    public void testAllQueryToListMap() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Map<String, Object>> stu = mapper.getAllStuToMap();
//        System.out.println("stu = " + stu);
        stu.forEach(System.out::println);
    }

}
