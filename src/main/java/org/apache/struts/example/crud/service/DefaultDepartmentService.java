package org.apache.struts.example.crud.service;

import org.apache.struts.example.crud.dao.DepartmentDao;
import org.apache.struts.example.crud.dao.InMemoryDepartmentDao;

import java.util.List;

public class DefaultDepartmentService implements DepartmentService {

    private DepartmentDao dao;

    public DefaultDepartmentService() {
        this.dao = new InMemoryDepartmentDao();
    }

    public List getAllDepartments() {
        return dao.getAllDepartments();
    }

}
