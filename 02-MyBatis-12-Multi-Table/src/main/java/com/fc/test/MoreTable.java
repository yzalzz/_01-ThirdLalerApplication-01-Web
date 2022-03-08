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
        DepartmentDao mapper = MyBatisUtil.getMapper(DepartmentDao.class);

        List<Department> id = mapper.findById(5);

        MyBatisUtil.commit();
        for (Department department : id) {
            System.out.println(department);
        }
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
