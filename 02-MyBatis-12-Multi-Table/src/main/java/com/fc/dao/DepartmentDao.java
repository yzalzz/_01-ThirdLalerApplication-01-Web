package com.fc.dao;

import com.fc.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
     Department findById(@Param("id") Integer id);

//     List<Department> findById(@Param("id")Integer id);
}
