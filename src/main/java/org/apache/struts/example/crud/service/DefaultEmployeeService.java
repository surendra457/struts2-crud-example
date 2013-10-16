package org.apache.struts.example.crud.service;

import org.apache.struts.example.crud.dao.EmployeeDao;
import org.apache.struts.example.crud.dao.InMemoryEmployeeDao;
import org.apache.struts.example.crud.model.Employee;

import java.util.List;

public class DefaultEmployeeService implements EmployeeService {

    private EmployeeDao dao;

    public DefaultEmployeeService() {
        this.dao = new InMemoryEmployeeDao();
    }

    public List getAllEmployees() {
        return dao.getAllEmployees();
    }

    public void updateEmployee(Employee emp) {
        dao.update(emp);
    }

    public void deleteEmployee(Integer id) {
        dao.delete(id);
    }

    public Employee getEmployee(Integer id) {
        return dao.getEmployee(id);
    }

    public void insertEmployee(Employee emp) {
        dao.insert(emp);
    }
}
