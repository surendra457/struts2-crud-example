package org.apache.struts.example.crud.dao;

import org.apache.struts.example.crud.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public List getAllEmployees();

    public Employee getEmployee(Integer id);

    public void update(Employee emp);

    public void insert(Employee emp);

    public void delete(Integer id);

}
