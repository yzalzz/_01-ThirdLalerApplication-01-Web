package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class MyBatisUtilTest {
    @Test
    public void  testFindById(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = studentDao.findById(1);

        MyBatisUtil.commit();

        System.out.println(student);
    }


    @Test
    public void testFindAll() {
        try {
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            MyBatisUtil.commit();

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (Exception e){
            MyBatisUtil.rollback();
        }
    }
}
