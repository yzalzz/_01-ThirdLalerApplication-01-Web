package com.fc.entity;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    //一对一
    //一个员工对应一个部门
    //这样写既可以拿到部门id又可以拿到部门name
    private Department department;
}
