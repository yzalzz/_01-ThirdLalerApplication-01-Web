package com.fc.test;

import com.fc.dao.DepartmentDao;
import com.fc.dao.EmployeeDao;
import com.fc.entity.Department;
import com.fc.entity.Employee;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class MoreTable {

    @Test
    public void testFindById(){
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);

        Department id = departmentDao.findById(5);

        MyBatisUtil.commit();

        System.out.println(id);
    }
    @Test
    public void test(){
        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);

        List<Employee> all = employeeDao.findAll();

        MyBatisUtil.commit();

        for (Employee employee : all) {

            System.out.println(employee);
        }
    }
}
