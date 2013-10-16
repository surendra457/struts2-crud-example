package org.apache.struts.example.crud.dao;

import org.apache.struts.example.crud.model.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {

    public List<Department> getAllDepartments();

    public Map<Integer, Department> getDepartmentsMap();

}
