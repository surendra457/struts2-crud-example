package org.apache.struts.example.crud.service;

import org.apache.struts.example.crud.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List getAllEmployees();

    public void updateEmployee(Employee emp);

    public void deleteEmployee(Integer id);

    public Employee getEmployee(Integer id);

    public void insertEmployee(Employee emp);

}
